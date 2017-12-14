package finalweb

class BootStrap {

    CarritoService carritoService
    Carrito car = new Carrito()
    def init = { servletContext ->


        Usuario u = Usuario.findByCorreo("ubeistore@gmail.com")? null: new Usuario(correo: "ubeistore@gmail.com",nombre : "Admin", apellido : "Admin", clave : "admin", telefono: 1234, direccion: "Admin", tipo: TipoUsuario.ADMIN).save(flush: true, failOnError: true)


        if(u){

            car.setUsuario(u)
            carritoService.save(car)
        }

    }
    def destroy = {
    }
}
