package opsas

import grails.gorm.services.Service

@Service(ServiceType)
interface ServiceTypeService {

    ServiceType get(Serializable id)

    List<ServiceType> list(Map args)

    Long count()

    void delete(Serializable id)

    ServiceType save(ServiceType serviceType)

}