package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.{Attribute,tAge}

case class Age(value: String) extends Attribute with tAge {

  private def age_eval(age: Int): Boolean = age >= 18 && age <= 65

  def verify(): Option[Boolean] = {

    if(value.matches("^[0-9]*$")) {
      val bool = age_eval(value.toInt)
      Some(bool)
    }
    else None
  }
}

case class ADefault(value: String = "Erro: Idade vazia") extends tAge
