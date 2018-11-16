package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.CPF
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestCPF extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "fail in cpf = 000.000.000-00" in {
    val cpf = CPF("000.000.000-00")
    cpf.verify() should be (None)
  }

  it should "accept in cpf = 00000000000" in {
    val cpf = CPF("00000000000")
    cpf.verify() should be (Some(true))
  }

  it should "fail when user inputs are chars" in {
    val cpf = CPF("!@#$%* ()_+{:><?|'){}'abc")
    cpf.verify() should be (None)
  }

  it should "cpf.value.len = 11" in {
    val cpf = CPF("00000000000")
    cpf.value.length should be (11)
  }

  it should "cpf.value.len == 11" in {
    val cpf = CPF("000")
    cpf.verify() should be (Some(false))
  }
}
