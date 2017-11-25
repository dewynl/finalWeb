package finalweb

import grails.gorm.services.Service

@Service(ItemOrden)
interface ItemOrdenService {

    ItemOrden get(Serializable id)

    List<ItemOrden> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemOrden save(ItemOrden itemOrden)

}