package finalweb

import grails.validation.ValidationException
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
            o.despachado = false
            o.recibido = false
            o.save(flush: true)

            carrito.itemOrdenes =  new HashSet<>()
            carrito.save(flush: true)

            String texto = ""
            texto  = "Orden nueva!\n\n"
            texto += "\tOrden No: ${o.id}\n"
            texto += "\tUsuario: ${o.usuario.nombre} ${o.usuario.apellido}\n\n"
            texto += "\tUsuario Direccion: ${o.usuario.direccion}\n"
            texto += "\tOrden Articulos: \n\n"
            o.itemOrden.each {
                texto+= "\t \t id:${it.articulo.id} nombre: ${it.articulo.nombre} cantidad: ${it.cantidad}\n"
            }
            texto+= "\t Total: ${o.total}"
            texto += "Un saludo."

            sendMail {
                multipart false
                subject "Ubei Store Registration"
                text texto
                to "ubeiAlmacen@gmail.com"
                from "ubeistore@gmail.com"
            }

            // mandar a buscar reportes
            //render(view: 'show', model: ["orden": o])
            forward(controller: 'orden', action: 'show/'+o.id, params: ['id': o.id])
        }
        else {
            redirect(url: "/")
        }
    }
}
