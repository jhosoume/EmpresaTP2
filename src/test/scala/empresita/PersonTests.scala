package empresita

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

import empresita.Main.format
import org.scalatest.{FlatSpec, Matchers}

class PersonTests extends FlatSpec with Matchers {

  val format = new SimpleDateFormat("dd-MM-yyyy")

  "The name" should "be set corretly in the constructor" in {
    val dummy = new Person("John", "123.456.789.00",
      format.parse("02-03-1962"), Lawyer)
    dummy.getName should equal ("John")
    }

  "Age" should "be answered in years" in {
    val dummy = new Person("John", "123.456.789.00",
      format.parse("02-03-1962"), Lawyer)
    dummy.age should equal(56)
  }
}
