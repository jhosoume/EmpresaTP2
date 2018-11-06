package empresita

import java.text.SimpleDateFormat
import java.util.Date

import empresita.positions._
import empresita.sectors.SectorContainer
import org.scalatest.{FlatSpec, Matchers}

class CompanyTests extends FlatSpec with Matchers {
  val format = new SimpleDateFormat("dd-MM-yyyy")

  val dummyCom = new Company("Monsters Inc.")

  "Sectors" should "be set correctly initialized" in {
    dummyCom.sectors shouldBe a [SectorContainer]
  }

  "Sectors from different companies" should "not be the same" in {
    val anotherCom = new Company("hardCom")
    anotherCom.sectors.design shouldNot be theSameInstanceAs dummyCom.sectors.design
  }


  val dummyComp = new Company("Dumb")
  val dummyEmp1 = new Employee("Emp1", "001", format.parse("01-01-1980"),
    Lawyer, dummyComp, new Date(), dummyComp.sectors.norm, Pro)
  val dummyEmp2 = new Employee("Emp2", "002", format.parse("01-01-1980"),
    Lawyer, dummyComp, new Date(), dummyComp.sectors.norm, SectorDirector)


  dummyComp.assign_execDirector(dummyEmp1)
  dummyComp.assign_opDirector(dummyEmp2)

  "Emp1" should "be Executive Director" in {
    dummyComp.exec_director should equal(dummyEmp1)
  }

  "Emp2" should "be Operative Director" in {
    dummyComp.op_director should equal(dummyEmp2)
  }

  "Company" should "have a function to hire employees" in {
    dummyCom.hire(new Person("John Alfred", "123.456.789-10", format.parse("10-11-1990"),
      SystemEngineer), dummyCom.sectors.tech, Technician)
    dummyCom.hire(new Person("George Walrus 2", "123.789.001-10", format.parse("21-09-1975"),
      Lawyer), dummyCom.sectors.design, Assistant)
    dummyCom.emps_names() should contain("John Alfred")
    dummyCom.emps_names() should contain("George Walrus 2")
  }

  "When informed a CPF, the company" should "find its employee" in {
    dummyCom.hire(new Person("John Alfred", "123.456.789-10", format.parse("10-11-1990"),
      SystemEngineer), dummyCom.sectors.tech, Technician)
    dummyCom.get_employee("123.456.789-10").name should equal("John Alfred")
  }

  "When a employee is fired, it" should "not be in the company list" in {
    dummyCom.hire(new Person("George Walrus 2", "123.789.001-10", format.parse("21-09-1975"),
      Lawyer), dummyCom.sectors.design, Assistant)
    val george = dummyCom.get_employee("123.789.001-10")
    dummyCom.emps_names() should contain("George Walrus 2")
    dummyCom.fire(george)
    dummyCom.emps_names() shouldNot contain("George Walrus 2")
  }

}
