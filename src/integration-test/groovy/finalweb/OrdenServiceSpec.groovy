package finalweb

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrdenServiceSpec extends Specification {

    OrdenService ordenService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Orden(...).save(flush: true, failOnError: true)
        //new Orden(...).save(flush: true, failOnError: true)
        //Orden orden = new Orden(...).save(flush: true, failOnError: true)
        //new Orden(...).save(flush: true, failOnError: true)
        //new Orden(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //orden.id
    }

    void "test get"() {
        setupData()

        expect:
        ordenService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Orden> ordenList = ordenService.list(max: 2, offset: 2)

        then:
        ordenList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ordenService.count() == 5
    }

    void "test delete"() {
        Long ordenId = setupData()

        expect:
        ordenService.count() == 5

        when:
        ordenService.delete(ordenId)
        sessionFactory.currentSession.flush()

        then:
        ordenService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Orden orden = new Orden()
        ordenService.save(orden)

        then:
        orden.id != null
    }
}
