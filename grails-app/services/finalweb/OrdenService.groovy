package finalweb

import grails.gorm.services.Service

@Service(Orden)
interface OrdenService {

    Orden get(Serializable id)

    List<Orden> list(Map args)

    Long count()

    void delete(Serializable id)

    Orden save(Orden orden)

}