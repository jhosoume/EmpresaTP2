package empresita

import java.text.SimpleDateFormat

import empresita.positions.Assistant
import org.scalatest.{FlatSpec, Matchers}

class SalaryTests extends FlatSpec with Matchers {
  val format = new SimpleDateFormat("dd-MM-yyyy")
  val company = new Company("Oranges")

  "Salary of an assitant without any raise" should "equal 1850" in {
    company.hire(new Person("Rufus", "180.300.500-45", format.parse("11-03-1977"), BasicSchooling),
      company.sectors.tech, Assistant)
//    val emp = company.get_employee("180.300.500-45")
  }
 }
