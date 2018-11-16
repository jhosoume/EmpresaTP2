package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.{Attribute,tName}

case class Name(value: String) extends Attribute with tName {

  def verify(): Option[Boolean] = Some(value.matches("^[a-zA-Z\\u00C0-\\u017F ]*$"))
}

case class NDefault(value: String = "Nome vazio") extends tName