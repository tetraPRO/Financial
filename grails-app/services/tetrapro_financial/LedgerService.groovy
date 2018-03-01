package tetrapro_financial

import grails.gorm.services.Service

@Service(Ledger)
interface LedgerService {

    Ledger get(Serializable id)

    List<Ledger> list(Map args)

    Long count()

    void delete(Serializable id)

    Ledger save(Ledger ledger)

}