package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.Date

case class BornDate(day: Int, month: Int, year: Int) extends Date{

  private def eval(): Boolean = {
    if(day <= 30 && month <= 12) year >= 1953 && year <= 2000
    else false
  }
  def verify(): Option[Boolean] = Some(eval())
}
