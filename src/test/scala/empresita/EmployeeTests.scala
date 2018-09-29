package empresita

import java.text.SimpleDateFormat

import empresita.positions._
import empresita.sectors._
import org.scalatest.{FlatSpec, Matchers}

class EmployeeTests extends FlatSpec with Matchers{
  val format = new SimpleDateFormat("dd-MM-yyyy")

  val IASA = new Company("IASA")

  val johnC = new Person("John Crichton", "11721812011",
    format.parse("11-12-1962"), SystemEngineer)

  IASA.hire(johnC, IASA.sectors.tech, Technician)

  "John Crichton" should "have been correctly hired by IASA" in {
    println(IASA.sectors.tech.emps)
    IASA.sectors.tech.getEmployee(johnC.CPF).CPF should equal(johnC.CPF)
  }

}
