package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DepartamentoController {

    DepartamentoService departamentoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        Usuario us = Usuario.findByCorreo(session.usuario)
        Integer total= 0
        for(ItemOrden a in Carrito.findByUsuario(us).itemOrdenes){
            total += (a.cantidad * a.articulo.precio)
        }
        return ['carrito': Carrito.findByUsuario(us).itemOrdenes.take(5), "total": total, departamentoCount: departamentoService.count(),'departamentos': departamentoService.list(params)]
    }

    def show(Long id) {
        respond departamentoService.get(id)
    }

    def create() {
        respond new Departamento(params)
    }

    def save(Departamento departamento) {
        if (departamento == null) {
            notFound()
            return
        }

        try {
            departamentoService.save(departamento)
        } catch (ValidationException e) {
            respond departamento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamento.id])
                redirect departamento
            }
            '*' { respond departamento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond departamentoService.get(id)
    }

    def update(Departamento departamento) {
        if (departamento == null) {
            notFound()
            return
        }

        try {
            departamentoService.save(departamento)
        } catch (ValidationException e) {
            respond departamento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamento.id])
                redirect departamento
            }
            '*'{ respond departamento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        departamentoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'departamento.label', default: 'Departamento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
