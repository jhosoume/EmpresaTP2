package br.unb.cic.tp2.traits

trait Attribute {

  val value: String
  def verify(): Option[Boolean]
}
