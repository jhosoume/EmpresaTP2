package empresita

import java.text.SimpleDateFormat

import empresita.positions.{SectorDirector, Technician, Assistant}
import empresita.sectors.{Sector, SectorContainer, Tech}
import org.scalatest.{FlatSpec, Matchers}


class SectorTests extends FlatSpec with Matchers {

  val format = new SimpleDateFormat("dd-MM-yyyy")
  val sectors = new SectorContainer

  "The sector container" should "make sectors available" in {
    sectors.tech.name should equal("Tech")
    sectors.getSector("Tech").name should equal ("Tech")
  }


  "The sector container" should "have the sectors defined" in {
    sectors.sectorsObjs() should contain (sectors.tech)
    sectors.sectorsObjs() should contain (sectors.norm)
    sectors.sectorsObjs() should contain (sectors.marketing)
    sectors.sectorsObjs() should contain (sectors.design)
    sectors.sectorsObjs() should contain (sectors.finance)
  }

  "The size of sector container" should "be at least 5" in {
    sectors.size() should be >= 5
  }

  "Sectors without employees" should "have mean salary of 0" in {
    sectors.tech.num_employee() should equal (0)
    sectors.tech.salaryAvg() should equal (0)
  }

  "The mean sector salary" should "equal the sum of the salary of all employees divided by its size" in {
    val company = new Company("Dummy Company")
    company.hire(new Person("John Alfred", "123.456.789-10", format.parse("10-11-1990"),
      SystemEngineer), company.sectors.tech, Technician)
    company.sectors.tech.salaryAvg() should equal(3350)
    company.hire(new Person("Manfred Griffin", "123.456.941-10", format.parse("10-09-1988"),
      SystemEngineer), company.sectors.tech, Technician)
    company.sectors.tech.salaryAvg() should equal(3350)
    company.hire(new Person("Geroge Walrus", "123.789.941-10", format.parse("09-09-1945"),
      ComputationEngineer), company.sectors.tech, SectorDirector)
    company.sectors.tech.salaryAvg() should equal(5463.33 +- 0.01)
  }

  "Adding an employee to another sector" should "not influence average" in {
    val company = new Company("Dummy Company")
    company.hire(new Person("John Alfred", "123.456.789-10", format.parse("10-11-1990"),
      SystemEngineer), company.sectors.tech, Technician)
    company.sectors.tech.salaryAvg() should equal(3350)
    company.hire(new Person("Geroge Walrus 2", "123.789.001-10", format.parse("21-09-1975"),
      Lawyer), company.sectors.design, Assistant)
    company.sectors.tech.salaryAvg() should equal(3350)

  }


}