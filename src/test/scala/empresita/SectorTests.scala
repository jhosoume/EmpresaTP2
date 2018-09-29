package empresita

import java.text.SimpleDateFormat

import empresita.sectors.{Sector, Tech, SectorContainer}
import org.scalatest.{FlatSpec, Matchers}


class SectorTests extends FlatSpec with Matchers {

  val format = new SimpleDateFormat("dd-MM-yyyy")
  val sectors = new SectorContainer

  "The sector container" should "make sectors available" in {
    sectors.tech.name should equal("Tech")
//    sectors.getSector("Tech").getClass should equal()
  }

}