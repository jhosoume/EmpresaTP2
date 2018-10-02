package empresita

import empresita.positions._
import org.scalatest.{FlatSpec, Matchers}

class PositionTests extends FlatSpec with Matchers {
  "Positions" should "be able to be ordered" in {
    (Assistant < Technician) should equal(true)
    (Technician < Pro) should equal(true)
    (Pro < Technician) should equal(false)
    (ExecutiveDirector > Technician) should equal(true)
    (OperationDirector > SectorDirector) should equal(true)
  }

  "Positions" should "have a compatible salary" in {
    Assistant.salary should equal(1500)
    Technician.salary should equal(3000)
    Pro.salary should equal(6500)
    SectorDirector.salary should equal(9500)
    OperationDirector.salary should equal(13000)
    ExecutiveDirector.salary should equal(18000)
  }
}

