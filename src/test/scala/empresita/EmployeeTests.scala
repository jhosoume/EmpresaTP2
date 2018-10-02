package empresita

import java.text.SimpleDateFormat
import java.util.Date

import empresita.positions._
import org.scalatest.{FlatSpec, Matchers}

class EmployeeTests extends FlatSpec with Matchers{
  val format = new SimpleDateFormat("dd-MM-yyyy")

  val IASA = new Company("IASA")

  val johnC = new Person("John Crichton", "11721812011",
    format.parse("11-12-1962"), SystemEngineer)

  IASA.hire(johnC, IASA.sectors.tech, Technician)

  "John Crichton's CPF" should " be linked to an employee" in {
    IASA.sectors.tech.getEmployee(johnC.CPF).CPF should equal(johnC.CPF)
  }

  "John Crichton" should "be listed as a Technician" in {
    IASA.sectors.tech.getEmployee(johnC.CPF).position should equal(Technician)
  }

  "The salary of a technician" should "be 3350" in {
    IASA.sectors.tech.getEmployee(johnC.CPF).salary should equal(3350)
  }

  val cobJ = new Employee("Cob Jones", "10023252500",
    format.parse("20-08-1960"), Admin, IASA, new Date(), IASA.sectors.finance,
    Pro)

  "Cob" should "be an employee at the finance department" in {
    IASA.sectors.finance.has_employee(cobJ.CPF) should equal(true)
  }

  "Cob" should " be the new finance sector director" in {
    cobJ.promote(SectorDirector)
    IASA.sectors.finance.director.name should equal(cobJ.name)
  }


  "Rygel" should " be the new finance sector director" in {
    cobJ.promote(SectorDirector)
    val rygelD = new Employee("Rygel Dominar", "17100066622",
      format.parse("20-09-1940"), Economist, IASA, new Date(), IASA.sectors.finance,
      SectorDirector)
    IASA.sectors.finance.director.name should equal(rygelD.name)
    IASA.sectors.finance.getEmployee(cobJ.CPF).position should equal(Pro)
  }

  val dummyComp = new Company("Dumb")
  val dummyEmp1 = new Employee("Emp1", "001", format.parse("01-01-1980"),
    Lawyer, dummyComp, new Date(), dummyComp.sectors.norm, Pro)
  val dummyEmp2 = new Employee("Emp2", "002", format.parse("01-01-1980"),
    Lawyer, dummyComp, new Date(), dummyComp.sectors.norm, SectorDirector)


  "The sector director" should " be changed to dummyEmp1" in {
    dummyComp.sectors.norm.change_director(dummyEmp1)
    dummyComp.sectors.norm.director should equal(dummyEmp1)
  }

  "Qualification of an employee" should "be easily changed" in {
    dummyEmp1.qualification = Account
    dummyEmp1.qualification should equal (Account)
  }


}
