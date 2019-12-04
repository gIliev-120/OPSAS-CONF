package opsas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AdministrativeStructuresServiceSpec extends Specification {

    AdministrativeStructuresService administrativeStructuresService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AdministrativeStructures(...).save(flush: true, failOnError: true)
        //new AdministrativeStructures(...).save(flush: true, failOnError: true)
        //AdministrativeStructures administrativeStructures = new AdministrativeStructures(...).save(flush: true, failOnError: true)
        //new AdministrativeStructures(...).save(flush: true, failOnError: true)
        //new AdministrativeStructures(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //administrativeStructures.id
    }

    void "test get"() {
        setupData()

        expect:
        administrativeStructuresService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AdministrativeStructures> administrativeStructuresList = administrativeStructuresService.list(max: 2, offset: 2)

        then:
        administrativeStructuresList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        administrativeStructuresService.count() == 5
    }

    void "test delete"() {
        Long administrativeStructuresId = setupData()

        expect:
        administrativeStructuresService.count() == 5

        when:
        administrativeStructuresService.delete(administrativeStructuresId)
        sessionFactory.currentSession.flush()

        then:
        administrativeStructuresService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AdministrativeStructures administrativeStructures = new AdministrativeStructures()
        administrativeStructuresService.save(administrativeStructures)

        then:
        administrativeStructures.id != null
    }
}
