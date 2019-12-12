package opsas

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN','ROLE_USER'])
class PaymentTransactionsController {

    PaymentTransactionsService paymentTransactionsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paymentTransactionsService.list(params), model:[paymentTransactionsCount: paymentTransactionsService.count()]
    }

    def show(Long id) {
        respond paymentTransactionsService.get(id)
    }

    def create() {
        respond new PaymentTransactions(params)
    }

    def save(PaymentTransactions paymentTransactions) {
        if (paymentTransactions == null) {
            notFound()
            return
        }

        try {
            paymentTransactionsService.save(paymentTransactions)
        } catch (ValidationException e) {
            respond paymentTransactions.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'paymentTransactions.label', default: 'PaymentTransactions'), paymentTransactions.id])
                redirect paymentTransactions
            }
            '*' { respond paymentTransactions, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond paymentTransactionsService.get(id)
    }

    def update(PaymentTransactions paymentTransactions) {
        if (paymentTransactions == null) {
            notFound()
            return
        }

        try {
            paymentTransactionsService.save(paymentTransactions)
        } catch (ValidationException e) {
            respond paymentTransactions.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'paymentTransactions.label', default: 'PaymentTransactions'), paymentTransactions.id])
                redirect paymentTransactions
            }
            '*'{ respond paymentTransactions, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        paymentTransactionsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'paymentTransactions.label', default: 'PaymentTransactions'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'paymentTransactions.label', default: 'PaymentTransactions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
