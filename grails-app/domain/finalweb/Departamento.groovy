package finalweb

class Departamento {

    String nombre

    Date dateCreated
    Date lastUpdated

    static constraints = {
        nombre nullable: false, blank: false
    }

    static mapping = {
        table 'departamento'
    }
}
