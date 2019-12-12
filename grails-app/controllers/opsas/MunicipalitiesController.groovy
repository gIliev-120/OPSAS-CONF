package opsas

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class MunicipalitiesController {

    MunicipalitiesService municipalitiesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond municipalitiesService.list(params), model:[municipalitiesCount: municipalitiesService.count()]
    }

    def show(Long id) {
        respond municipalitiesService.get(id)
    }

    def create() {
        respond new Municipalities(params)
    }

    def save(Municipalities municipalities) {
        if (municipalities == null) {
            notFound()
            return
        }

        try {
            municipalitiesService.save(municipalities)
        } catch (ValidationException e) {
            respond municipalities.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'municipalities.label', default: 'Municipalities'), municipalities.id])
                redirect municipalities
            }
            '*' { respond municipalities, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond municipalitiesService.get(id)
    }

    def update(Municipalities municipalities) {
        if (municipalities == null) {
            notFound()
            return
        }

        try {
            municipalitiesService.save(municipalities)
        } catch (ValidationException e) {
            respond municipalities.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'municipalities.label', default: 'Municipalities'), municipalities.id])
                redirect municipalities
            }
            '*'{ respond municipalities, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        municipalitiesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'municipalities.label', default: 'Municipalities'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'municipalities.label', default: 'Municipalities'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
