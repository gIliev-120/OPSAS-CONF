package opsas

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class AdministrativeStructuresController {

    AdministrativeStructuresService administrativeStructuresService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond administrativeStructuresService.list(params), model:[administrativeStructuresCount: administrativeStructuresService.count()]
    }

    def show(Long id) {
        respond administrativeStructuresService.get(id)
    }

    def create() {
        respond new AdministrativeStructures(params)
    }

    def save(AdministrativeStructures administrativeStructures) {
        if (administrativeStructures == null) {
            notFound()
            return
        }

        try {
            administrativeStructuresService.save(administrativeStructures)
        } catch (ValidationException e) {
            respond administrativeStructures.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'administrativeStructures.label', default: 'AdministrativeStructures'), administrativeStructures.id])
                redirect administrativeStructures
            }
            '*' { respond administrativeStructures, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond administrativeStructuresService.get(id)
    }

    def update(AdministrativeStructures administrativeStructures) {
        if (administrativeStructures == null) {
            notFound()
            return
        }

        try {
            administrativeStructuresService.save(administrativeStructures)
        } catch (ValidationException e) {
            respond administrativeStructures.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'administrativeStructures.label', default: 'AdministrativeStructures'), administrativeStructures.id])
                redirect administrativeStructures
            }
            '*'{ respond administrativeStructures, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        administrativeStructuresService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'administrativeStructures.label', default: 'AdministrativeStructures'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'administrativeStructures.label', default: 'AdministrativeStructures'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
