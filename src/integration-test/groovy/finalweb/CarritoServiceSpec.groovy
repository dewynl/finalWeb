package finalweb

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CarritoServiceSpec extends Specification {

    CarritoService carritoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Carrito(...).save(flush: true, failOnError: true)
        //new Carrito(...).save(flush: true, failOnError: true)
        //Carrito carrito = new Carrito(...).save(flush: true, failOnError: true)
        //new Carrito(...).save(flush: true, failOnError: true)
        //new Carrito(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //carrito.id
    }

    void "test get"() {
        setupData()

        expect:
        carritoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Carrito> carritoList = carritoService.list(max: 2, offset: 2)

        then:
        carritoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        carritoService.count() == 5
    }

    void "test delete"() {
        Long carritoId = setupData()

        expect:
        carritoService.count() == 5

        when:
        carritoService.delete(carritoId)
        sessionFactory.currentSession.flush()

        then:
        carritoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Carrito carrito = new Carrito()
        carritoService.save(carrito)

        then:
        carrito.id != null
    }
}
