package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.{Attribute, Title,tPayment}

case class Payment(value: String, title: Title) extends Attribute with tPayment {

  def verify(): Option[Boolean] = {
    if(value.matches("^[0-9]*$")) {
      Some(true)
    }
    else None
  }
}

case class PDefault(value: String = "Erro: Pagamento vazio") extends tPayment
