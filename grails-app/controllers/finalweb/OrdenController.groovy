package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrdenController {

    OrdenService ordenService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ordenService.list(params), model:[ordenCount: ordenService.count()]
    }

    def show(Long id) {
        respond ordenService.get(id)
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
}
