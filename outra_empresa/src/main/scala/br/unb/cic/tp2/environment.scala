package br.unb.cic.tp2

import br.unb.cic.tp2.atributos.Id
import br.unb.cic.tp2.traits.{Attribute,Date}

object environment {

  def employeeValidation(alpha: Attribute, beta: Attribute, date: Date): Option[Boolean] = {

    alpha.verify() match {
      case None => return None
      case Some(bool) => if (!bool) return Some(false)
    }
    beta.verify() match {
      case None => return None
      case Some(bool) => if (!bool) return Some(false)
    }
    date.verify() match {
      case None => return None
      case Some(bool) => if (!bool) return Some(false)
    }
    Some(true)
  }

  def id(alpha: Attribute, beta: Attribute, date: Date): Id = {
    val aux_code = alpha.value + beta.value
    val year     = date.year.toString.drop(2)
    val code     = Math.abs(aux_code.hashCode % 1000000).toString

    Id(year + '/' + code)
  }
}
