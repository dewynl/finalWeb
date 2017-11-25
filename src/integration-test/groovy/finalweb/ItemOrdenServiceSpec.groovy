package finalweb

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemOrdenServiceSpec extends Specification {

    ItemOrdenService itemOrdenService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemOrden(...).save(flush: true, failOnError: true)
        //new ItemOrden(...).save(flush: true, failOnError: true)
        //ItemOrden itemOrden = new ItemOrden(...).save(flush: true, failOnError: true)
        //new ItemOrden(...).save(flush: true, failOnError: true)
        //new ItemOrden(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemOrden.id
    }

    void "test get"() {
        setupData()

        expect:
        itemOrdenService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemOrden> itemOrdenList = itemOrdenService.list(max: 2, offset: 2)

        then:
        itemOrdenList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemOrdenService.count() == 5
    }

    void "test delete"() {
        Long itemOrdenId = setupData()

        expect:
        itemOrdenService.count() == 5

        when:
        itemOrdenService.delete(itemOrdenId)
        sessionFactory.currentSession.flush()

        then:
        itemOrdenService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemOrden itemOrden = new ItemOrden()
        itemOrdenService.save(itemOrden)

        then:
        itemOrden.id != null
    }
}
