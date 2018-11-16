package br.unb.cic.tp2.traits

sealed trait tGenre

case class Male()         extends tGenre
case class Female()       extends tGenre
case class GenreDefault() extends tGenre
