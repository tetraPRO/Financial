package tetrapro_financial

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LedgerController {

    LedgerService ledgerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ledgerService.list(params), model:[ledgerCount: ledgerService.count()]
    }

    def show(Long id) {
        respond ledgerService.get(id)
    }

    def create() {
        respond new Ledger(params)
    }

    def save(Ledger ledger) {
        if (ledger == null) {
            notFound()
            return
        }

        try {
            ledgerService.save(ledger)
        } catch (ValidationException e) {
            respond ledger.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ledger.label', default: 'Ledger'), ledger.id])
                redirect ledger
            }
            '*' { respond ledger, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ledgerService.get(id)
    }

    def update(Ledger ledger) {
        if (ledger == null) {
            notFound()
            return
        }

        try {
            ledgerService.save(ledger)
        } catch (ValidationException e) {
            respond ledger.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ledger.label', default: 'Ledger'), ledger.id])
                redirect ledger
            }
            '*'{ respond ledger, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ledgerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ledger.label', default: 'Ledger'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ledger.label', default: 'Ledger'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
