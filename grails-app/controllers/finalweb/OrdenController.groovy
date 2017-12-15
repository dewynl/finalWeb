package finalweb

import finalweb.reports.ResumenOrden
import grails.validation.ValidationException
import net.sf.jasperreports.engine.JRExporter
import net.sf.jasperreports.engine.JRExporterParameter
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.export.JRPdfExporter
import pl.touk.excel.export.WebXlsxExporter

import static org.springframework.http.HttpStatus.*



class OrdenController {

    OrdenService ordenService
    ArticuloService articuloService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        if(!session.usuario) {
            redirect(url: '/usuario/login')
        } else if(!Usuario.findByCorreo(session.usuario).tipo in [TipoUsuario.ALMACEN, TipoUsuario.ADMIN]) redirect(url: '/')

        params.max = Math.min(max ?: 10, 100)
        Usuario us = Usuario.findByCorreo(session.usuario)
        Integer total= 0
        for(ItemOrden a in Carrito.findByUsuario(us).itemOrdenes){
            total += (a.cantidad * a.articulo.precio)
        }

        List<Orden> lista = new ArrayList<Orden>()
        for(Orden o : ordenService.list(params)) {
            if (!o.despachado) lista.add(o)
        }
        return [ ordenCount: ordenService.count(), 'ordenes': lista, 'carrito': Carrito.findByUsuario(us).itemOrdenes.take(5), "total": total]
    }

    def despachar (Long id){

        Orden o = Orden.findById(id)
        o.despachado = true
        o.save(flush: true)
        redirect action:"index", method:"GET"

    }
    def usuarioOrdenes(Integer max){
        params.max = Math.min(max ?: 10, 100)
        Usuario us = Usuario.findByCorreo(session.usuario)
        Integer total= 0
        for(ItemOrden a in Carrito.findByUsuario(us).itemOrdenes){
            total += (a.cantidad * a.articulo.precio)
        }
        def list = new ArrayList<>()
        Orden.findAllByUsuario(us).each {
            if(!it.recibido) list.add(it)
        }

        return [ ordenCount: ordenService.count(), 'ordenes': list , 'carrito': Carrito.findByUsuario(us).itemOrdenes.take(5), "total": total]
    }
    def recibir (Long id){

        Orden o = Orden.findById(id)
        o.recibido = true
        o.save(flush: true)
        redirect url:"/orden/usuarioOrdenes"

    }

    def show(Long id) {
        if(Usuario.findByCorreo(session.usuario)) return ['orden': ordenService.get(id)]
        else redirect(url: '/usuario/login')
    }

    def create() {
        if(Usuario.findByCorreo(session.usuario)) respond new Orden(params)
        else redirect(url: '/usuario/login')
    }

    def save(Orden orden) {
        if (orden == null) {
            notFound()
            return
        }

        try {
            ordenService.save(orden)
        } catch (ValidationException e) {
            respond orden.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orden.label', default: 'Orden'), orden.id])
                redirect orden
            }
            '*' { respond orden, [status: CREATED] }
        }
    }

    def edit(Long id) {
        if(Usuario.findByCorreo(session.usuario)) respond ordenService.get(id)
        else redirect(url: '/usuario/login')
    }

    def update(Orden orden) {
        if (orden == null) {
            notFound()
            return
        }

        try {
            ordenService.save(orden)
        } catch (ValidationException e) {
            respond orden.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orden.label', default: 'Orden'), orden.id])
                redirect orden
            }
            '*'{ respond orden, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ordenService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orden.label', default: 'Orden'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orden.label', default: 'Orden'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def generar_archivo_despacho(Orden orden) {
        ByteArrayOutputStream pdfStream = null
        try {
            String reportName, jrxmlFileName, dotJasperFileName
            jrxmlFileName = "Dispatch"
            reportName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jrxml").file.getAbsoluteFile()
            dotJasperFileName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jasper").file.getAbsoluteFile()
            println reportName

            Map<String, Object> reportParam = new HashMap<String, Object>()
            def listItems = ResumenOrden.generarListaResumen(orden)
            println orden
            def dataSource = new JRBeanCollectionDataSource(listItems)

            reportParam.put("nombreUsuario", orden.usuario.nombre + " " + orden.usuario.apellido)
            reportParam.put("emailUsuario", orden.usuario.correo)
            reportParam.put("numeroOrden", "ORD" + orden.id as String)
            reportParam.put("totalFactura",'US$' + orden.total as String)
            reportParam.put("direccion", orden.usuario.direccion)

            JasperCompileManager.compileReportToFile(reportName)
            JasperPrint print = JasperFillManager.fillReport(dotJasperFileName, reportParam, dataSource);

            pdfStream = new ByteArrayOutputStream()
            JRExporter exporter = new JRPdfExporter()
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print)
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, pdfStream) // your output goes here

            exporter.exportReport()

        } catch (Exception e) {
            println e
            println e.message
        } finally {

            // EMAIL SUPPLIERS:
            def sendTo = []
            sendTo.add("dewyn.liriano@gmail.com")
            ArrayList<Usuario> usuarios = Usuario.findAllByTipo(TipoUsuario.ALMACEN)
            usuarios.each{
                sendTo.add(it.correo)
            }

            sendMail {
                multipart true
                subject "Nueva orden para despachar"
                text "Descargue el archivo con las informaciones de la orden"
                to sendTo
                from "ubeistore@gmail.com"
                attach "depacho_orden.pdf", "application/pdf", pdfStream.toByteArray()
            }
        }
    }


    def recibo_compra() {

        if(params.correcto && Usuario.findByCorreo(session.usuario)) {
            // crear facturas
            Usuario currentUser = Usuario.findByCorreo(session.usuario)
            Carrito carrito = Carrito.findByUsuario(currentUser)
            Orden o = new Orden()
            o.usuario = currentUser
            o.itemOrden = new HashSet<ItemOrden>()
            carrito.itemOrdenes.each {
                Articulo a = it.articulo
                a.cantidad -= it.cantidad
                a.save(flush: true)
                o.itemOrden.add(it)
            }
            o.generarTotal()
            o.generarRNC()
            o.despachado = false
            o.recibido = false
            o.save(flush: true)

            carrito.itemOrdenes =  new HashSet<>()
            carrito.save(flush: true)

            this.generar_archivo_despacho(o)

            // mandar a buscar reportes

            //render(view: 'show', model: ["orden": o])
            render(view: 'show', model: ['orden' : o])

        }
        else {
            redirect(url: "/")
        }
    }
    def generar_excel() {

        List<Orden> Ordenes = Orden.findAll();
        def rows = []

        Ordenes.each {
            def id = it.id
            def compradorNombre = it.usuario.nombre
            def total = it.total


            it.itemOrden.each{ io->
                def valx = new HashMap()
                valx['OrdenNo'] = id
                valx['NombreUsuario'] = compradorNombre
                valx['Ordentotal'] = total
                valx['mercanciaId'] = io.id
                valx['mercanciaNombre'] = io.articulo.nombre
                valx['mercanciaPrecio'] = io.articulo.precio
                rows.add(valx)

            }
        }
        def withProperties = ['OrdenNo', 'NombreUsuario','Ordentotal', 'mercanciaId', 'mercanciaNombre', 'mercanciaPrecio']
        def headers = ['Id', 'Comprador Nombre','Orden total', 'Mercancia Id', 'Mercancia Nombre', 'Mercancia Precio']
        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(rows, withProperties)
            save(response.outputStream)
        }

    }
}
