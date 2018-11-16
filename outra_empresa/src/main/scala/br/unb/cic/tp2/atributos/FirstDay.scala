package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.Date

case class FirstDay(day: Int, month: Int, year: Int) extends Date {

  private def eval(): Boolean = day <= 30 && month <= 12 && year >= 2000
  def verify(): Option[Boolean] = Some(eval())
}
