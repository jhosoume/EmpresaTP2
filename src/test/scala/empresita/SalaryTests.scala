package empresita

import java.text.SimpleDateFormat

import empresita.positions._
import org.scalatest.{FlatSpec, Matchers}

class SalaryTests extends FlatSpec with Matchers {
  val format = new SimpleDateFormat("dd-MM-yyyy")
  val company = new Company("Oranges")

  "Salary of an assitant without any raise" should "equal 1850" in {
    company.hire(new Person("Rufus Rufus", "180.300.500-45", format.parse("11-03-1977"), BasicSchooling),
      company.sectors.tech, Assistant)
    company.get_employee("180.300.500-45").salary() should equal(1850)
  }

  "Salary of an technician without any raise" should "equal 3350" in {
    company.hire(new Person("Rufus Cufis", "180.300.500-46", format.parse("11-03-1977"), BasicSchooling),
      company.sectors.design, Technician)
    company.get_employee("180.300.500-46").salary() should equal(3350)
  }

  "Salary of an technician with a raise of 150" should "equal 3500" in {
    company.hire(new Person("Rufus Oufis", "180.300.500-46", format.parse("11-03-1977"), BasicSchooling),
      company.sectors.design, Technician)
    val emp = company.get_employee("180.300.5" +
      "00-46")
    emp.raise_salary = 150
    emp.salary() should equal(3500)
  }

  "Salary of a pro without any raise" should "equal 6500" in {
    company.hire(new Person("Rufus Pufis", "180.300.500-47", format.parse("11-03-1977"), SystemEngineer),
      company.sectors.tech, Pro)
    company.get_employee("180.300.500-47").salary() should equal(6500)
  }

  "Salary of a sector director without any raise" should "equal 9500 plus 2% bonus" in {
    company.hire(new Person("Rufus Tchufis", "180.300.500-48", format.parse("11-03-1977"), ComputerEngineer),
      company.sectors.tech, SectorDirector)
    company.get_employee("180.300.500-48").salary() should equal(9500*1.02)
  }

  "Salary of a operation director without any raise" should "equal 13000 plus 2% bonus" in {
    company.hire(new Person("Rufus Lufis", "180.300.500-49", format.parse("11-03-1977"), ComputerEngineer),
      company.sectors.tech, OperationDirector)
    company.get_employee("180.300.500-49").salary() should equal(13000*1.02)
  }

  "Salary of a executive director without any raise" should "equal 13000 plus 2% bonus" in {
    company.hire(new Person("Rufus Rufis", "180.300.500-50", format.parse("11-03-1977"), ComputerEngineer),
      company.sectors.tech, ExecutiveDirector)
    company.get_employee("180.300.500-50").salary() should equal(18000*1.02)
  }

  "Mean salary of a company without employee" should "be zero" in {
    val new_company = new Company("Brand new Company")
    new_company.empsSalaryMean() should equal (0)
  }

  "Mean salary of a company with many employees" should "be calculated correclty" in {
    company.empsSalaryMean() should equal(8072.86 +- 0.01)
    company.hire(new Person("Manfred Griffin", "123.456.941-10", format.parse("10-09-1988"),
      SystemEngineer), company.sectors.norm, Technician)
    company.empsSalaryMean() should equal(7482.5 +- 0.01)
    company.hire(new Person("Geroge Walrus", "123.789.941-10", format.parse("09-09-1945"),
      Market), company.sectors.marketing, SectorDirector)
    company.empsSalaryMean() should equal(7727.77 +- 0.01)
  }
 }
