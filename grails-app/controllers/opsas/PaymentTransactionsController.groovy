package opsas

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN','ROLE_USER'])
class PaymentTransactionController {

    PaymentTransactionService paymentTransactionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paymentTransactionService.list(params), model:[paymentTransactionCount: paymentTransactionService.count()]
    }

    def show(Long id) {
        respond paymentTransactionService.get(id)
    }

    def create() {
        respond new PaymentTransaction(params)
    }

    def save(PaymentTransaction paymentTransaction) {
        if (paymentTransaction == null) {
            notFound()
            return
        }

        try {
            paymentTransactionService.save(paymentTransaction)
        } catch (ValidationException e) {
            respond paymentTransaction.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'paymentTransaction.label', default: 'PaymentTransaction'), paymentTransaction.id])
                redirect paymentTransaction
            }
            '*' { respond paymentTransaction, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond paymentTransactionService.get(id)
    }

    def update(PaymentTransaction paymentTransaction) {
        if (paymentTransaction == null) {
            notFound()
            return
        }

        try {
            paymentTransactionService.save(paymentTransaction)
        } catch (ValidationException e) {
            respond paymentTransaction.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'paymentTransaction.label', default: 'PaymentTransaction'), paymentTransaction.id])
                redirect paymentTransaction
            }
            '*'{ respond paymentTransaction, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        paymentTransactionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'paymentTransaction.label', default: 'PaymentTransaction'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'paymentTransaction.label', default: 'PaymentTransaction'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
