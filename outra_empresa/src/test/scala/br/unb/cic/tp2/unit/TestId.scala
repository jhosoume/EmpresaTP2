package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.Id
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestId extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "accept in id =  16/0001234" in {
    val id = Id("16/0001234")
    id.verify() should be (Some(true))
  }

  it should "return the same value" in {
    val id = Id("16/0001234")
    id.value should be ("16/0001234")
  }

  it should "match with pattern yy/xxxxxxx" in {
    val id = Id("160001234")
    id.verify() should be (Some(false))
  }

  it should "id.value.lenght = 10" in {
    val id = Id("16/0001234")
    id.value.length() should be (10)
  }

  it should "fail in id = !@#$%* ()_+{:><?|'){}'abc" in {
    val id = Id("!@#$%* ()_+{:><?|'){}'abc")
    id.verify() should be (None)
  }
}
