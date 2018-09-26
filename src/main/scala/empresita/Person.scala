package empresita

import java.util.Date

class Person(val name: String, val CPF: String, val age: Int, val birthday: Date, var qualification: Qualification) {
  def getName: String = {
    return name
  }
}
