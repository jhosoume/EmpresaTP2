package empresita

sealed trait Qualification

case object Admin               extends Qualification
case object Account             extends Qualification
case object Economist           extends Qualification
case object Communication       extends Qualification
case object Marketing           extends Qualification
case object ComputationEngineer extends Qualification
case object SystemEngineer      extends Qualification
case object InformationEngineer extends Qualification
case object Lawyer              extends Qualification
case object GraphicDesigner     extends Qualification
case object MultimediaDesigner  extends Qualification
case object SocialEngineer      extends Qualification

