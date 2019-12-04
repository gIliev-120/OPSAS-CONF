package opsas

import grails.gorm.services.Service

@Service(AdministrativeStructures)
interface AdministrativeStructuresService {

    AdministrativeStructures get(Serializable id)

    List<AdministrativeStructures> list(Map args)

    Long count()

    void delete(Serializable id)

    AdministrativeStructures save(AdministrativeStructures administrativeStructures)

}