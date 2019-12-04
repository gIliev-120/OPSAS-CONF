package opsas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BankDetailsServiceSpec extends Specification {

    BankDetailsService bankDetailsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new BankDetails(...).save(flush: true, failOnError: true)
        //new BankDetails(...).save(flush: true, failOnError: true)
        //BankDetails bankDetails = new BankDetails(...).save(flush: true, failOnError: true)
        //new BankDetails(...).save(flush: true, failOnError: true)
        //new BankDetails(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bankDetails.id
    }

    void "test get"() {
        setupData()

        expect:
        bankDetailsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<BankDetails> bankDetailsList = bankDetailsService.list(max: 2, offset: 2)

        then:
        bankDetailsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bankDetailsService.count() == 5
    }

    void "test delete"() {
        Long bankDetailsId = setupData()

        expect:
        bankDetailsService.count() == 5

        when:
        bankDetailsService.delete(bankDetailsId)
        sessionFactory.currentSession.flush()

        then:
        bankDetailsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        BankDetails bankDetails = new BankDetails()
        bankDetailsService.save(bankDetails)

        then:
        bankDetails.id != null
    }
}
