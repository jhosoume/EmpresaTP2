package br.unb.cic.tp2.traits

trait Date {
  val day   : Int
  val month : Int
  val year  : Int

  def verify(): Option[Boolean]
}

case class DDefault(day: Int = -1, month: Int = -1, year: Int = -1) extends Date {

  def verify(): Option[Boolean] = None
}
