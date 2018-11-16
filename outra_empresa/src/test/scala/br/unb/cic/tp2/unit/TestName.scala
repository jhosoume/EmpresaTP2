package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.Name
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestName extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "return the same value" in {
    val name = Name("joao")
    name.value should be ("joao")
  }

  it should "accept lower case chars" in {
    val name = Name("joao")
    name.verify() should be (Some(true))
  }

  it should "accept _ case chars" in {
    val name = Name("JOAO")
    name.verify() should be (Some(true))
  }

  it should "accept __ case chars" in {
    val name = Name("Joao")
    name.verify() should be (Some(true))
  }

  it should "accept ~" in {
    val name = Name("João")
    name.verify() should be (Some(true))
  }

  it should "accept '... xxxx yyyy ...' name pattern" in {
    val name = Name("João Gabriel")
    name.verify() should be (Some(true ))
  }

  it should "fail in names with numbers and special chars" in {
    val name = Name("!@#$%* ()_+{:><?|'){}'123456789")
    name.verify() should be (Some(false))
  }
}
