package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemOrdenController {

    ItemOrdenService itemOrdenService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond itemOrdenService.list(params), model:[itemOrdenCount: itemOrdenService.count()]
    }

    def show(Long id) {
        respond itemOrdenService.get(id)
    }

    def create() {
        respond new ItemOrden(params)
    }

    def save(ItemOrden itemOrden) {
        if (itemOrden == null) {
            notFound()
            return
        }

        try {
            itemOrdenService.save(itemOrden)
        } catch (ValidationException e) {
            respond itemOrden.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemOrden.label', default: 'ItemOrden'), itemOrden.id])
                redirect itemOrden
            }
            '*' { respond itemOrden, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond itemOrdenService.get(id)
    }

    def update(ItemOrden itemOrden) {
        if (itemOrden == null) {
            notFound()
            return
        }

        try {
            itemOrdenService.save(itemOrden)
        } catch (ValidationException e) {
            respond itemOrden.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'itemOrden.label', default: 'ItemOrden'), itemOrden.id])
                redirect itemOrden
            }
            '*'{ respond itemOrden, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        itemOrdenService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemOrden.label', default: 'ItemOrden'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemOrden.label', default: 'ItemOrden'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
