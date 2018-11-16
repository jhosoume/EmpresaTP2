package br.unb.cic.tp2.traits

import br.unb.cic.tp2.atributos.{CPF, Name}

trait Employee {

  def getName      : tName
  def getCPF       : tCPF
  def getFirstDay  : Date
  def getBorndate  : Date
  def getId        : tId

  def getPayment   : tPayment
  def getAge       : tAge
  def getSector    : Sector
  def getCargo     : Title

  def setBorndate(s: Date)     : Unit
  def setPayment (s: String)   : Unit
  def setAge     (s: String)   : Unit
  def setSector  (s: Sector)   : Unit
  def setCargo   (s: Title)    : Unit
  def setGraduate(s: Graduate) : Unit
}
