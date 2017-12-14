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
        params.max = Math.min(max ?: 10, 100)
        Usuario us = Usuario.findByNombre("Eva")
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

    def show(Long id) {
        return ['orden': ordenService.get(id)]
    }

    def create() {
        respond new Orden(params)
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
        respond ordenService.get(id)
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
            /* def supplyRole = Role.findByAuthority("ROLE_SUPPLY")
             def users = UserRole.findAllByRole(supplyRole)*/
            /* users.each {
                 sendTo.add(it.user.email)
             }*/

            sendMail {
                multipart true
                subject "Dispatch Request"
                text "You will be finding a dispatch request attached bellow."
                to sendTo
                from "ubeistore@gmail.com"
                attach "dispatch.pdf", "application/pdf", pdfStream.toByteArray()
            }
        }
    }


    def recibo_compra() {
        println session.usuario
        if(params.correcto && session.usuario) {
            // crear facturas
            Usuario currentUser = session.usuario
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
            render(view: 'show', model: ["orden": o])
            //redirect(controller: 'orden', action: 'show/'+o.id, params: ['id': o.id])
        }
        else {
            redirect(url: "/")
        }
    }
    def generar_excel() {

        List<Orden> Ordenes = Orden.findAll();
        def algo = []

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
                algo.add(valx)

            }
        }
        def withProperties = ['OrdenNo', 'NombreUsuario','Ordentotal', 'mercanciaId', 'mercanciaNombre', 'mercanciaPrecio']
        def headers = ['Id', 'Comprador Nombre','Orden total', 'Mercancia Id', 'Mercancia Nombre', 'Mercancia Precio']
        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(algo, withProperties)
            save(response.outputStream)
        }

    }
}
