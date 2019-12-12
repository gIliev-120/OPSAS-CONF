package opsas

import grails.gorm.services.Service

@Service(PaymentTransactions)
interface PaymentTransactionsService {

    PaymentTransactions get(Serializable id)

    List<PaymentTransactions> list(Map args)

    Long count()

    void delete(Serializable id)

    PaymentTransactions save(PaymentTransactions paymentTransactions)

}