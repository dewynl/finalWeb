package finalweb

class Carrito {

    Usuario usuario
    Set<ItemOrden> itemOrdenes

    Date dateCreated
    Date lastUpdated

    static constraints = {
        usuario nullable: false
    }

    static mapping = {
        table 'carrito'
    }
}
