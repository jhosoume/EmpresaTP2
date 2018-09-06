package empresita

import org.scalatest.{FlatSpec, Matchers}

class PersonTests extends FlatSpec with Matchers {
  "The name" should "be set corretly in the constructor" in {
    val dummy = new Person("John", "123.456.789.00", 20)
    dummy.getName should equal ("John")
  }

}
