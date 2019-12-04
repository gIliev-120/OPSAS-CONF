package opsas

import grails.gorm.services.Service

@Service(Municipalities)
interface MunicipalitiesService {

    Municipalities get(Serializable id)

    List<Municipalities> list(Map args)

    Long count()

    void delete(Serializable id)

    Municipalities save(Municipalities municipalities)

}