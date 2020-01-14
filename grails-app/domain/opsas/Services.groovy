package opsas

class Services {
    String name;
    String paymentCode;
    String description;
    static hasMany = [type: ServiceType]
    static belongsTo = [administrativeStructure: AdministrativeStructures]

    static constraints = {
    }
}
