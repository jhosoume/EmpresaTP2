package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.Payment
import br.unb.cic.tp2.traits.TDefault
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestPayment extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "return the same value" in {
    val payment = Payment("1000",TDefault())
    payment.value should be ("1000")
  }

  it should "accept numbers" in {
    val payment = Payment("1000",TDefault())
    payment.verify() should be (Some(true))
  }

  it should "fail in payments with !@#$%* ()_+{:>.;,<?|'){}'abc" in {
    val payment = Payment("!@#$%* ()_+{:><?.;<,|'){}'abc", TDefault())
    payment.verify() should be (None)
  }
}
