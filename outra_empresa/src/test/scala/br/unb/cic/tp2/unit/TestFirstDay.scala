package br.unb.cic.tp2.unit

import br.unb.cic.tp2.atributos.FirstDay
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestFirstDay extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

  it should "return the same day" in {
    val firstDay = FirstDay(24,6,2000)
    firstDay.day should be (24)
  }

  it should "return the same month" in {
    val firstDay = FirstDay(24,6,2000)
    firstDay.month should be (6)
  }

  it should "return the same year" in {
    val firstDay = FirstDay(24,6,2000)
    firstDay.year should be (2000)
  }

  it should "date >= 01/01/2000" in {
    val firstDay = FirstDay(1,1,2000)
    firstDay.verify() should be (Some(true))
  }

  it should "date >= 001/01/2000" in {
    val firstDay = FirstDay(30,12,1999)
    firstDay.verify() should be (Some(false))
  }

  it should "1 <= month <= 12" in {
    val firstDay = FirstDay(30,13,2000)
    firstDay.verify() should be (Some(false))
  }

  it should "1 <= day <= 30" in {
    val firstDay = FirstDay(31,12,2000)
    firstDay.verify() should be (Some(false))
  }
}
