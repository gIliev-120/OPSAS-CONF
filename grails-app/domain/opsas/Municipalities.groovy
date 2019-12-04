package opsas

class Municipalities {
    String name;
    String code;
    static hasMany = [structures: AdministrativeStructures];


    static constraints = {

    }
}
