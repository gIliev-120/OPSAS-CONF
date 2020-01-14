package enums

enum Status {
    WAITING("D"), //DRAFT
    IN_PROGRESS("S"), //STARTED
    READY("F") //FINISHED

    String id

    Status(String id){
        this.id = id
    }

}