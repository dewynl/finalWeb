package finalweb

import grails.converters.JSON

class ApiController {

    def index() {}

    def validar_usuario() {
        response.setHeader("Access-Control-Allow-Origin", "*")
        String correo = params.correo
        String clave = params.clave
        Usuario usuario = Usuario.findByCorreo(correo)
        if (usuario != null && usuario.clave == clave && usuario.tipo == TipoUsuario.ADMIN) {
            ArrayList<Usuario> usuarios = Usuario.findAllByTipoInList([TipoUsuario.CLIENTE_CONSUMIDOR_FINAL,
                                                                       TipoUsuario.CLIENTE_PERSONA_FISICA,
                                                                       TipoUsuario.CLIENTE_EMPRESA])
            render usuarios as JSON
        } else {
            render false
        }
    }

    def buscar_ordenes(){
        response.setHeader("Access-Control-Allow-Origin", "*")
        def id = params.id
        Usuario u = Usuario.findById(id);
        ArrayList<Orden> ordenes = Orden.findAllByUsuario(u)
        render ordenes as JSON
    }

}
