package tetrapro_financial

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BudgetServiceSpec extends Specification {

    BudgetService budgetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Budget(...).save(flush: true, failOnError: true)
        //new Budget(...).save(flush: true, failOnError: true)
        //Budget budget = new Budget(...).save(flush: true, failOnError: true)
        //new Budget(...).save(flush: true, failOnError: true)
        //new Budget(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //budget.id
    }

    void "test get"() {
        setupData()

        expect:
        budgetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Budget> budgetList = budgetService.list(max: 2, offset: 2)

        then:
        budgetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        budgetService.count() == 5
    }

    void "test delete"() {
        Long budgetId = setupData()

        expect:
        budgetService.count() == 5

        when:
        budgetService.delete(budgetId)
        sessionFactory.currentSession.flush()

        then:
        budgetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Budget budget = new Budget()
        budgetService.save(budget)

        then:
        budget.id != null
    }
}
