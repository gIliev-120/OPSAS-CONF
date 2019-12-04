package opsas

class Services {
    String name;
    String paymentCode;
    static hasMany = [type:ServiceType]
    static belongsTo = [administrativeStructure: AdministrativeStructures]

    static constraints = {
    }
}
