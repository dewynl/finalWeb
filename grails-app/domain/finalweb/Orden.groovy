package finalweb

class Orden {

    Usuario usuario
    Set<ItemOrden> itemOrden
    Double total
    boolean despachado
    boolean recibido

    Date dateCreated
    Date lastUpdated

    static constraints = {
        usuario nullable: false, blank: false
        total min: 0d, nullable: false, blank: false
        despachado nullable: false, blank: false
        recibido nullable: false, blank: false
    }

    static mapping = {
        table 'orden'
        despachado defaultValue: false
        recibido defaultValue: false
    }
}
