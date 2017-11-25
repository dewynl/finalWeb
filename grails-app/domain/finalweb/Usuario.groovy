package finalweb

class Usuario {

    String correo
    String nombre
    String apellido
    String clave
    String telefono
    String direccion

    Date dateCreated
    Date lastUpdated

    static constraints = {
        correo nullable: false, blank: false, unique: true
        nombre blank: false, nullable: false
        apellido blank: false, nullable: false
        telefono blank: true, nullable: true
        direccion blank: false, nullable: false
        clave blank: false, password: true

    }
}
