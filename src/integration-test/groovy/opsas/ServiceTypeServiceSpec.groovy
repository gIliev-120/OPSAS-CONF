package opsas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ServiceTypeServiceSpec extends Specification {

    ServiceTypeService serviceTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ServiceType(...).save(flush: true, failOnError: true)
        //new ServiceType(...).save(flush: true, failOnError: true)
        //ServiceType serviceType = new ServiceType(...).save(flush: true, failOnError: true)
        //new ServiceType(...).save(flush: true, failOnError: true)
        //new ServiceType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //serviceType.id
    }

    void "test get"() {
        setupData()

        expect:
        serviceTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ServiceType> serviceTypeList = serviceTypeService.list(max: 2, offset: 2)

        then:
        serviceTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        serviceTypeService.count() == 5
    }

    void "test delete"() {
        Long serviceTypeId = setupData()

        expect:
        serviceTypeService.count() == 5

        when:
        serviceTypeService.delete(serviceTypeId)
        sessionFactory.currentSession.flush()

        then:
        serviceTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ServiceType serviceType = new ServiceType()
        serviceTypeService.save(serviceType)

        then:
        serviceType.id != null
    }
}
