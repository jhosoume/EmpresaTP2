package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.Age
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}
class TestAge extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "fail in age < 18" in {
    val age = Age("17")
    age.verify() should be (Some(false))
  }

  it should "fail in age > 65" in {
    val age = Age("66")
    age.verify() should be (Some(false))
  }

  it should "accept in age = 18" in {
    val age = Age("18")
    age.verify() should be (Some(true))
  }

  it should "accept in age = 65" in {
    val age = Age("65")
    age.verify() should be (Some(true))
  }

  it should "accept in age = 30" in {
    val age = Age("30")
    age.verify() should be (Some(true))
  }

  it should "fail in age('!@#$%* ()_+{:><?|'){}'abc)" in {
    val age = Age("!@#$%* ()_+{:><?|'){}abc")
    age.verify() should be (None)
  }
}
