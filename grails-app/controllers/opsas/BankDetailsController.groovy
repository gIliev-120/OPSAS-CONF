package opsas

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class BankDetailsController {

    BankDetailsService bankDetailsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bankDetailsService.list(params), model:[bankDetailsCount: bankDetailsService.count()]
    }

    def show(Long id) {
        respond bankDetailsService.get(id)
    }

    def create() {
        respond new BankDetails(params)
    }

    def save(BankDetails bankDetails) {
        if (bankDetails == null) {
            notFound()
            return
        }

        try {
            bankDetailsService.save(bankDetails)
        } catch (ValidationException e) {
            respond bankDetails.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bankDetails.label', default: 'BankDetails'), bankDetails.id])
                redirect bankDetails
            }
            '*' { respond bankDetails, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bankDetailsService.get(id)
    }

    def update(BankDetails bankDetails) {
        if (bankDetails == null) {
            notFound()
            return
        }

        try {
            bankDetailsService.save(bankDetails)
        } catch (ValidationException e) {
            respond bankDetails.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bankDetails.label', default: 'BankDetails'), bankDetails.id])
                redirect bankDetails
            }
            '*'{ respond bankDetails, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bankDetailsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bankDetails.label', default: 'BankDetails'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankDetails.label', default: 'BankDetails'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
