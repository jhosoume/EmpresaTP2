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
}

