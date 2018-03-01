package tetrapro_financial

class Budget {

  Double rentmortgage
  Double utilities
  Double cellphones
  Double vehicle
  Double insurance
  Double gas
  Double creditcards
  Double entertainment
  Double foodgroceries
  Double clothing
  Double medical
  Double fees
  Double education
  Double other
  Double futureself

    static constraints = {
      rentmortgage()
      utilities()
      cellphones()
      vehicle()
      insurance()
      gas()
      creditcards()
      entertainment()
      foodgroceries()
      clothing()
      medical()
      fees()
      education()
      other()
      futureself()
    }
}
