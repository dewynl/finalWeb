package finalweb

class Articulo {

    String nombre
    float precio
    float peso
    long cantidad
    byte[] foto

    Date dateCreated
    Date lastUpdated

    static constraints = {
        nombre nullable: false, blank: false
        precio min: 0f, nullable: false, blank: false
        peso min: 0f, nullable: false, blank: false
        cantidad min: 0l, nullable: false, blank: false
        foto blank: false, nullable: false
    }

    static mapping = {
        table 'articulo'
    }
}
