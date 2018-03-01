package tetrapro_financial

import grails.gorm.services.Service

@Service(Budget)
interface BudgetService {

    Budget get(Serializable id)

    List<Budget> list(Map args)

    Long count()

    void delete(Serializable id)

    Budget save(Budget budget)

}