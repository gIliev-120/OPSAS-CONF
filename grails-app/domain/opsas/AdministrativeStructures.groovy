package opsas

class AdministrativeStructures {
    String name;
    String code;

    static hasMany = [services: Services]
    //static hasOne = [bankDetail:BankDetails]
    static belongsTo = [municipality: Municipalities]

    static constraints = {
    }
}
