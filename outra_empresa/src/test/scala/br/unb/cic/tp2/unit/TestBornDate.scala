package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.BornDate
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestBornDate extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "return the same day" in {
    val bornDate = BornDate(24,6,1975)
    bornDate.day should be (24)
  }

  it should "return the same month" in {
    val bornDate = BornDate(24,6,1975)
    bornDate.month should be (6)
  }

  it should "return the same year" in {
    val bornDate = BornDate(24,6,1975)
    bornDate.year should be (1975)
  }

  it should "accept only bornDates < x/y/2001" in {
    val bornDate = BornDate(30,12,2000)
    bornDate.verify() should be (Some(true))
  }

  it should "accept only bornDates < xx/yy/2001" in {
    val bornDate = BornDate(1,1,2001)
    bornDate.verify() should be (Some(false))
  }

  it should "accept only bornDates > xx/yy/1953" in {
    val bornDate = BornDate(1,1,1953)
    bornDate.verify() should be (Some(true))
  }

  it should "accept only bornDates > x/y/1953" in {
    val bornDate = BornDate(30,12,1952)
    bornDate.verify() should be (Some(false))
  }

  it should "1 <= month <= 12" in {
    val bornDate = BornDate(30,13,2000)
    bornDate.verify() should be (Some(false))
  }

  it should "1 <= day <= 30" in {
    val firstDay = BornDate(31, 12, 2000)
    firstDay.verify() should be(Some(false))
  }
}
