package br.unb.cic.tp2.traits

/*
  Aqui estão situadas as classes que representam
  os cargos da empresa organizados por hierarquia.
 */

sealed trait Title {
  def verify(g: List[Graduate]): Option[Boolean]
}

case class TGeneralDirector()     extends Title {
  def verify(g: List[Graduate]): Option[Boolean] = {
    Some(true)
  }
}
case class TOperationalDirector() extends Title {
  def verify(g: List[Graduate]): Option[Boolean] = {
    Some(true)
  }
}
case class TDepartmentDirector()  extends Title {
  def verify(g: List[Graduate]): Option[Boolean] = {
    Some(true)
  }
}
case class TProfessional()        extends Title {
  def verify(g: List[Graduate]): Option[Boolean] = {
    if(g.exists(a =>
      a match {
        case _: FinancialGraduate   => true
        case _: NormativityGraduate => true
        case _: DesignGraduate      => true
        case _: TechnologyGraduate  => true
        case _: MarketingGraduate   => true
        case _                      => false

      }
    )) Some(true)
    else Some(false)
  }
}
case class TTechnician()          extends Title {
  def verify(g: List[Graduate]): Option[Boolean] = {
    if(g.contains(Technician())) Some(true)
    else Some(false)
  }
}
case class TAuxiliaries()         extends Title {
  def verify(g: List[Graduate]): Option[Boolean] = {
    if(g.contains(Assistant())) Some(true)
    else Some(false)
  }
}
case class TDefault(string : String = "Erro: Sem cargo.")             extends Title { // Cargo padrão de toda novo objeto da classe Employee.
  def verify(g: List[Graduate]): Option[Boolean] = {
    Some(false)
  }
}
