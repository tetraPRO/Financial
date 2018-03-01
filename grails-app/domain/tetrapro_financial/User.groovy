package tetrapro_financial

class User {

  String firstName
  String lastName
  String passwordHash
  String confirmPassword
  String email

    static constraints = {
      firstName blank: false, nullable: false
      lastName blank: false, nullable: false
      passwordHash blank: false, nullable: false, password: true
      confirmPassword blank: false, nullable: false, password: true
    }
}
