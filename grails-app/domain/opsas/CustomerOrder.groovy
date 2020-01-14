package opsas

import enums.Status

class CustomerOrder {
    PaymentTransaction transaction;
    Services service;
    ServiceType type;
    String person
    String uic;
    Status status
    boolean paymentConfirmed



    static constraints = {
        status enumType: 'string'
    }
}
