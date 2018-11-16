package br.unb.cic.tp2.atributos

import br.unb.cic.tp2.traits.{Attribute,tCPF}

case class CPF(value: String) extends Attribute with tCPF {

  private def len_eval(): Boolean = value.length == 11 // Tamanho do CPF

  private def string_eval(): Boolean = {
    val array_aux = value.toArray

    for(i <- array_aux.indices) {

      if((i == 3 || i == 7 || i == 11) && array_aux(i) != '.') false
      else if(!array_aux(i).isDigit) false

    }
    true
  }

  def verify(): Option[Boolean] = {
    if(value.matches("^[0-9]*$")) {
      val bool = string_eval() && len_eval()
      Some(bool)
    }
    else None
  }
}

case class CPFDefault(value: String = "Erro: CPF vazio") extends tCPF
