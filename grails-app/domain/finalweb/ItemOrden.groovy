package finalweb

class ItemOrden {

    Articulo articulo
    int cantidad

    Date dateCreated
    Date lastUpdated

    static constraints = {
        articulo nullable: false, blank: false
        cantidad min: 1i
    }

    static mapping = {
        table 'ItemOrden'
    }
}
