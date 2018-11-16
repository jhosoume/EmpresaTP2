package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.{Attribute,tId}

case class Id(value: String) extends Attribute with tId {

  def verify(): Option[Boolean] = {

    var flag = true

    if(value.matches("^[0-9/]*$")) {

      if(value(2) != '/') return Some(false)
      for(i <- value.indices) {
        if(i != 2) flag = value(i) != '/'
      }
      Some(flag)
    }
    else None
  }
}

case class IdDefault(value: String = "Erro: Id Vazio") extends tId