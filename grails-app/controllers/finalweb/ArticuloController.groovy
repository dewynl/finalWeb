package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ArticuloController {

    ArticuloService articuloService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
     //   println("HOlaa"+articuloService.list(params).size())
        Usuario us = Usuario.findByNombre("Eva")
        Integer total= 0
        for(ItemOrden a in Carrito.findByUsuario(us).itemOrdenes){
            total += (a.cantidad * a.articulo.precio)
        }
        return [ articuloCount: articuloService.count(), 'articulos': articuloService.list(params), 'carrito': Carrito.findByUsuario(us).itemOrdenes, "total": total]
    }

    def show(Long id) {
        return ['articulo': articuloService.get(id)]
    }

    def create() {
        respond new Articulo(params)
    }

    def save(Articulo articulo) {

        articulo.foto = params.file.bytes.encodeBase64()

        if (articulo == null) {
            notFound()
            return
        }

        try {
            articuloService.save(articulo)
        } catch (ValidationException e) {
            respond articulo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'articulo.label', default: 'Articulo'), articulo.id])
                redirect articulo
            }
            '*' { respond articulo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond articuloService.get(id)
    }

    def update(Articulo articulo) {
        if (articulo == null) {
            notFound()
            return
        }

        try {
            articuloService.save(articulo)
        } catch (ValidationException e) {
            respond articulo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'articulo.label', default: 'Articulo'), articulo.id])
                redirect articulo
            }
            '*'{ respond articulo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        articuloService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'articulo.label', default: 'Articulo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulo.label', default: 'Articulo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
