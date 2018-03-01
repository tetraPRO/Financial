package tetrapro_financial

class Ledger {

  Date date = new Date()
  String accountTo
  String accountFrom
  Double debit
  Double credit
  String notes

    static constraints = {
      date()
      accountTo()
      accountFrom()
      debit()
      credit()
      notes()
    }
}
