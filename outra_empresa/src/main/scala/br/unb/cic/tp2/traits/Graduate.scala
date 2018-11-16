package br.unb.cic.tp2.traits

sealed trait Graduate
sealed trait FinancialGraduate
sealed trait MarketingGraduate
sealed trait TechnologyGraduate
sealed trait NormativityGraduate
sealed trait DesignGraduate
sealed trait TechnicianGraduate
sealed trait AssistantGraduate


case class Assistant()     extends AssistantGraduate with Graduate
case class Technician()    extends TechnicianGraduate with Graduate
case class Economist()     extends FinancialGraduate with Graduate

case class Marketer()      extends MarketingGraduate with Graduate

case class ComputerEng()   extends TechnologyGraduate with Graduate
case class SystemEng()     extends TechnologyGraduate with Graduate
case class InformEng()     extends TechnologyGraduate with Graduate

case class Lawyer()        extends NormativityGraduate with Graduate

case class GraphicDesign() extends DesignGraduate with Graduate
case class MultmedDesign() extends DesignGraduate with Graduate
case class SocialEng()     extends DesignGraduate with Graduate

case class Administrator() extends FinancialGraduate with MarketingGraduate with Graduate
case class Accountant()    extends FinancialGraduate with NormativityGraduate with Graduate
case class SocialComum()   extends MarketingGraduate with NormativityGraduate with Graduate
case class GDefault()      extends Graduate