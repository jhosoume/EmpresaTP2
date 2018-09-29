package empresita

import empresita.sectors.SectorContainer
import org.scalatest.{FlatSpec, Matchers}

class CompanyTests extends FlatSpec with Matchers {
  val dummyCom = new Company("Monsters Inc.")

  "Sectors" should "be set correctly initialized" in {
    dummyCom.sectors shouldBe a [SectorContainer]
  }

  "Sectors from different companies" should "not be the same" in {
    val anotherCom = new Company("hardCom")
    anotherCom.sectors.design shouldNot be theSameInstanceAs dummyCom.sectors.design
  }

}
