package empresita

sealed trait Genre

case object Male extends Genre
case object Female extends Genre
case object Unspecified extends Genre
