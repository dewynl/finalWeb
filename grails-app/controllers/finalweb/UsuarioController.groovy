package finalweb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UsuarioController {

    UsuarioService usuarioService
    CarritoService carritoService
    DepartamentoService departamentoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login(){
        Usuario u = Usuario.findByCorreo(params.username)

        if(u){
            if(u.clave.equals(params.password)){
                //render "siii"
                session.usuario = u.correo
                println(session.usuario)
                redirect(url: '/articulo/index')
            }

        }else {
            render(view: 'login', model: 'usuario')
        }

    }
    def logout (){
        session.usuario = null
        render(view: 'login', model: 'usuario')
    }



    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        Usuario us = Usuario.findByCorreo(session.usuario)
        Integer total= 0
        for(ItemOrden a in Carrito.findByUsuario(us).itemOrdenes){
            total += (a.cantidad * a.articulo.precio)
        }
        return ['carrito': Carrito.findByUsuario(us).itemOrdenes.take(5), "total": total, usuarioCount: usuarioService.count(), 'usuarios': usuarioService.list(params)]
    }

    def show(Long id) {
        if(session.usuario) respond usuarioService.get(id)
        else redirect(url: '/usuario/login')
    }

    def create() {
        if(session.usuario) return ['tipos': TipoUsuario.getListaTipos()]
        else redirect(url: '/usuario/login')
    }

    def save(Usuario usuario) {

        if (usuario == null) {
            notFound()
            return
        }

        try {
            usuarioService.save(usuario)
            Carrito car = new Carrito()
            car.setUsuario(usuario)
            carritoService.save(car)
        } catch (ValidationException e) {
            respond usuario.errors, view:'create'
            return
        }


        if(usuario.tipo in [TipoUsuario.CLIENTE_CONSUMIDOR_FINAL, TipoUsuario.CLIENTE_EMPRESA,
                            TipoUsuario.CLIENTE_PERSONA_FISICA]) {
            String texto = ""
            texto  = "Gracias por registrarte en Ubei Store!\n\n"
            texto += "Puedes entrar a la tienda en el enlace http://localhost:7878\n"
            texto += "\tUsuario: ${usuario.correo}\n"
            texto += "\tPassword: ${usuario.clave}\n\n"
            texto += "Un saludo."

            sendMail {
                multipart false
                subject "Ubei Store Registration"
                text texto
                to usuario.correo
                from "ubeistore@gmail.com"
            }
        }



        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*' { respond usuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        if(session.usuario) respond usuarioService.get(id)
        else redirect(url: '/usuario/login')
    }

    def update(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*'{ respond usuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        usuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
