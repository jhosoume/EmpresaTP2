package br.unb.cic.tp2.traits

/*
  Aqui estão os setores da empresa.
 */
sealed trait Sector {
  def verify(g: List[Employee]): Option[Boolean]
}

case class SFinances()    extends Sector {
  def verify(g: List[Employee]): Option[Boolean] = {
    Some(true)
  }
}
case class SMarketing()   extends Sector {
  def verify(g: List[Employee]): Option[Boolean] = {
    Some(true)
  }
}
case class STechnology()  extends Sector {
  def verify(g: List[Employee]): Option[Boolean] = {
    Some(true)
  }
}
case class SDesign()      extends Sector {
  def verify(g: List[Employee]): Option[Boolean] = {
    Some(true)
  }
}
case class SNormativity() extends Sector {
  def verify(g: List[Employee]): Option[Boolean] = {
    Some(true)
  }
}
case class SDefault(string : String = "Erro: Sem setor")     extends Sector { // Setor padrão de toda novo objeto da classe Employee.
  def verify(g: List[Employee]): Option[Boolean] = {
    Some(true)
  }
}


