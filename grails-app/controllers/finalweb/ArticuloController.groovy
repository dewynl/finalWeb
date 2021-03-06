package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ArticuloController {

    ArticuloService articuloService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        Usuario us = Usuario.findByCorreo(session.usuario)

        if(us){
            params.max = Math.min(max ?: 10, 100)
            Integer total = 0
            for (ItemOrden a in Carrito.findByUsuario(us).itemOrdenes) {
                total += (a.cantidad * a.articulo.precio)
            }
            List<Articulo> lista = new ArrayList<>()

            articuloService.list(params).each {
                if(it.cantidad>0) lista.add(it)
            }

            return [articuloCount: articuloService.count(), 'articulos': articuloService.list(params), 'carrito': Carrito.findByUsuario(us).itemOrdenes, "total": total]

        }else redirect(url: '/usuario/login')
    }

    def show(Long id) {
        if(Usuario.findByCorreo(session.usuario)) return ['articulo': articuloService.get(id)]
        else redirect(url: '/usuario/login')
    }

    def create() {
        if(!session.usuario) {
            redirect(url: '/usuario/login')
        } else if(!Usuario.findByCorreo(session.usuario).tipo.equals(TipoUsuario.ADMIN) ) redirect(url: '/')

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
            respond articulo.errors, view: 'create'
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
        if(Usuario.findByCorreo(session.usuario))
            respond articuloService.get(id)
        else redirect(url: '/usuario/login')
    }

    def update(Articulo articulo) {
        if (articulo == null) {
            notFound()
            return
        }

        try {
            articuloService.save(articulo)
        } catch (ValidationException e) {
            respond articulo.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'articulo.label', default: 'Articulo'), articulo.id])
                redirect articulo
            }
            '*' { respond articulo, [status: OK] }
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
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulo.label', default: 'Articulo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
