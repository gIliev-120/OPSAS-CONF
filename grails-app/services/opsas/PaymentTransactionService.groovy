package opsas

import grails.gorm.services.Service

@Service(PaymentTransaction)
interface PaymentTransactionService {

    PaymentTransaction get(Serializable id)

    List<PaymentTransaction> list(Map args)

    Long count()

    void delete(Serializable id)

    PaymentTransaction save(PaymentTransaction paymentTransactions)

}