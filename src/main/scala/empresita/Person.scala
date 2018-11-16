package empresita

import java.time.{LocalDate, Period, ZoneId}
import java.util.Date

class Person(val name: String, val CPF: String, val birthday: Date, var qualification: Qualification, val genre: Genre = Unspecified) {
  def getName: String = {
    name
  }

  val bday: LocalDate = birthday.toInstant.atZone(ZoneId.systemDefault()).toLocalDate

  def age: Int = {
    Period.between(bday, LocalDate.now).getYears
  }
}
