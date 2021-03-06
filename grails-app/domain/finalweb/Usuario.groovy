package finalweb

class Usuario implements Serializable {

    String correo
    String nombre
    String apellido
    String clave
    String telefono
    String direccion
    TipoUsuario tipo

    Date dateCreated
    Date lastUpdated

    static constraints = {
        correo nullable: false, blank: false, unique: true
        nombre blank: false, nullable: false
        apellido blank: false, nullable: false
        telefono blank: true, nullable: true
        direccion blank: false, nullable: false
        clave blank: false, nullable: false, password: true
        tipo nullable: false
    }

    static mapping = {
        table 'usuario'
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", clave='" + clave + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipo=" + tipo +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
