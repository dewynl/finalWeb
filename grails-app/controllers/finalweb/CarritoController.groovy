package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CarritoController {

    CarritoService carritoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond carritoService.list(params), model:[carritoCount: carritoService.count()]
    }

    def show(Long id) {
        respond carritoService.get(id)
    }

    def create() {
        respond new Carrito(params)
    }

    def agregar() {

        println(params.cantidad)

        Articulo a = Articulo.findById(Integer.parseInt(params.id_articulo))

        Usuario us = Usuario.findByNombre("Eva")

        //Usuario usuario=(Usuario) applicationContext.springSecurityService.getCurrentUser()

        Carrito c = Carrito.findByUsuario(us)


        if(a.cantidad >= Integer.parseInt(params.cantidad)) {
            ItemOrden io = new ItemOrden()
            io.setArticulo(a)
            io.setCantidad(Integer.parseInt(params.cantidad))

            c.itemOrdenes.add(io)
            println("adentro -> "+ Carrito.findByUsuario(us).itemOrdenes.size())

            flash.message = "Producto ${a.nombre} agregado al carrito!"
        }
        else {
            flash.error = "Producto ${a.nombre} No tiene suficiente existencia!"
        }
        redirect(controller: 'producto', action: 'catalogo')
    }

    def save(Carrito carrito) {
        if (carrito == null) {
            notFound()
            return
        }

        try {
            carritoService.save(carrito)
        } catch (ValidationException e) {
            respond carrito.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carrito.label', default: 'Carrito'), carrito.id])
                redirect carrito
            }
            '*' { respond carrito, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond carritoService.get(id)
    }

    def update(Carrito carrito) {
        if (carrito == null) {
            notFound()
            return
        }

        try {
            carritoService.save(carrito)
        } catch (ValidationException e) {
            respond carrito.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'carrito.label', default: 'Carrito'), carrito.id])
                redirect carrito
            }
            '*'{ respond carrito, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        carritoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'carrito.label', default: 'Carrito'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carrito.label', default: 'Carrito'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
