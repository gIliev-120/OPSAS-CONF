package opsas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MunicipalitiesServiceSpec extends Specification {

    MunicipalitiesService municipalitiesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Municipalities(...).save(flush: true, failOnError: true)
        //new Municipalities(...).save(flush: true, failOnError: true)
        //Municipalities municipalities = new Municipalities(...).save(flush: true, failOnError: true)
        //new Municipalities(...).save(flush: true, failOnError: true)
        //new Municipalities(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //municipalities.id
    }

    void "test get"() {
        setupData()

        expect:
        municipalitiesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Municipalities> municipalitiesList = municipalitiesService.list(max: 2, offset: 2)

        then:
        municipalitiesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        municipalitiesService.count() == 5
    }

    void "test delete"() {
        Long municipalitiesId = setupData()

        expect:
        municipalitiesService.count() == 5

        when:
        municipalitiesService.delete(municipalitiesId)
        sessionFactory.currentSession.flush()

        then:
        municipalitiesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Municipalities municipalities = new Municipalities()
        municipalitiesService.save(municipalities)

        then:
        municipalities.id != null
    }
}
