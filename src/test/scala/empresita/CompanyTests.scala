package empresita

import java.text.SimpleDateFormat
import java.util.Date

import empresita.positions.{Pro, SectorDirector}
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

}
