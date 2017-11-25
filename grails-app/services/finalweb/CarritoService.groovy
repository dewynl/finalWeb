package finalweb

import grails.gorm.services.Service

@Service(Carrito)
interface CarritoService {

    Carrito get(Serializable id)

    List<Carrito> list(Map args)

    Long count()

    void delete(Serializable id)

    Carrito save(Carrito carrito)

}