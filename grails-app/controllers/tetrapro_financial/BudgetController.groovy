package tetrapro_financial

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BudgetController {

    BudgetService budgetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond budgetService.list(params), model:[budgetCount: budgetService.count()]
    }

    def show(Long id) {
        respond budgetService.get(id)
    }

    def create() {
        respond new Budget(params)
    }

    def save(Budget budget) {
        if (budget == null) {
            notFound()
            return
        }

        try {
            budgetService.save(budget)
        } catch (ValidationException e) {
            respond budget.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'budget.label', default: 'Budget'), budget.id])
                redirect budget
            }
            '*' { respond budget, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond budgetService.get(id)
    }

    def update(Budget budget) {
        if (budget == null) {
            notFound()
            return
        }

        try {
            budgetService.save(budget)
        } catch (ValidationException e) {
            respond budget.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'budget.label', default: 'Budget'), budget.id])
                redirect budget
            }
            '*'{ respond budget, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        budgetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'budget.label', default: 'Budget'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'budget.label', default: 'Budget'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
