package finalweb

class Articulo implements Serializable {

    String nombre
    float precio
    float peso
    long cantidad
    String foto

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
        foto sqlType: 'text'
    }


    @Override
    String toString() {
        return "Articulo{" +
                "id=" + id +
                ", version=" + version +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", peso=" + peso +
                ", cantidad=" + cantidad +
                ", foto=" + foto.size() +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}'
    }
}
