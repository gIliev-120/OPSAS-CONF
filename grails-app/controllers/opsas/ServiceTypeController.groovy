package opsas

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class ServiceTypeController {

    ServiceTypeService serviceTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond serviceTypeService.list(params), model:[serviceTypeCount: serviceTypeService.count()]
    }

    def show(Long id) {
        respond serviceTypeService.get(id)
    }

    def create() {
        respond new ServiceType(params)
    }

    def save(ServiceType serviceType) {
        if (serviceType == null) {
            notFound()
            return
        }

        try {
            serviceTypeService.save(serviceType)
        } catch (ValidationException e) {
            respond serviceType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'serviceType.label', default: 'ServiceType'), serviceType.id])
                redirect serviceType
            }
            '*' { respond serviceType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond serviceTypeService.get(id)
    }

    def update(ServiceType serviceType) {
        if (serviceType == null) {
            notFound()
            return
        }

        try {
            serviceTypeService.save(serviceType)
        } catch (ValidationException e) {
            respond serviceType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'serviceType.label', default: 'ServiceType'), serviceType.id])
                redirect serviceType
            }
            '*'{ respond serviceType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        serviceTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'serviceType.label', default: 'ServiceType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'serviceType.label', default: 'ServiceType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
