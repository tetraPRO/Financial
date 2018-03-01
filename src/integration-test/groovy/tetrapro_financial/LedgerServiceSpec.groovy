package tetrapro_financial

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LedgerServiceSpec extends Specification {

    LedgerService ledgerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ledger(...).save(flush: true, failOnError: true)
        //new Ledger(...).save(flush: true, failOnError: true)
        //Ledger ledger = new Ledger(...).save(flush: true, failOnError: true)
        //new Ledger(...).save(flush: true, failOnError: true)
        //new Ledger(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ledger.id
    }

    void "test get"() {
        setupData()

        expect:
        ledgerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ledger> ledgerList = ledgerService.list(max: 2, offset: 2)

        then:
        ledgerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ledgerService.count() == 5
    }

    void "test delete"() {
        Long ledgerId = setupData()

        expect:
        ledgerService.count() == 5

        when:
        ledgerService.delete(ledgerId)
        sessionFactory.currentSession.flush()

        then:
        ledgerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ledger ledger = new Ledger()
        ledgerService.save(ledger)

        then:
        ledger.id != null
    }
}
