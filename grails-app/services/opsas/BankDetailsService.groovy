package opsas

import grails.gorm.services.Service

@Service(BankDetails)
interface BankDetailsService {

    BankDetails get(Serializable id)

    List<BankDetails> list(Map args)

    Long count()

    void delete(Serializable id)

    BankDetails save(BankDetails bankDetails)

}