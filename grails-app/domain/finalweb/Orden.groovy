package finalweb

class Orden implements Serializable {

    Usuario usuario
    Set<ItemOrden> itemOrden
    Double total = 0d
    String comprobante
    boolean despachado = false
    boolean recibido = false

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

    def generarTotal(){
        this.itemOrden.each {
            this.total+=it.articulo.precio * it.cantidad
        }
    }

    String generarRNC(){
        def result = "A0100100102" +  String.format("%08d", Orden.count());
        this.comprobante = result
    }
}
