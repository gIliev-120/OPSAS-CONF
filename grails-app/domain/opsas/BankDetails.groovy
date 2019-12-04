package opsas

class BankDetails {
    String name
    String account


    static belongsTo = [structure: AdministrativeStructures]
    static constraints = {
    }
}
