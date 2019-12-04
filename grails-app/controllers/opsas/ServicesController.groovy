package opsas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ServicesController {

    ServicesService servicesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond servicesService.list(params), model:[servicesCount: servicesService.count()]
    }

    def show(Long id) {
        respond servicesService.get(id)
    }

    def create() {
        respond new Services(params)
    }

    def save(Services services) {
        if (services == null) {
            notFound()
            return
        }

        try {
            servicesService.save(services)
        } catch (ValidationException e) {
            respond services.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'services.label', default: 'Services'), services.id])
                redirect services
            }
            '*' { respond services, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond servicesService.get(id)
    }

    def update(Services services) {
        if (services == null) {
            notFound()
            return
        }

        try {
            servicesService.save(services)
        } catch (ValidationException e) {
            respond services.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'services.label', default: 'Services'), services.id])
                redirect services
            }
            '*'{ respond services, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        servicesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'services.label', default: 'Services'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'services.label', default: 'Services'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
