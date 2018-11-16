package br.unb.cic.tp2.classes

import br.unb.cic.tp2.InvalidArgument
import br.unb.cic.tp2.traits._
import br.unb.cic.tp2.atributos._
import br.unb.cic.tp2.environment

class EmployeeClass(name: Name, cpf: CPF,firstDay: FirstDay) extends Employee {

  environment.employeeValidation(name,cpf,firstDay) match {
    case None       => throw InvalidArgument("Erro: name e/ou cpf e/ou firstDay não existentes.")
    case Some(bool) => if(!bool) throw InvalidArgument("Erro: Entradas não seguem o padrão.")
  }

  private val _id       : tId            = environment.id(name,cpf,firstDay)

  private var _bornDate : Date           = DDefault()
  private var _payment  : tPayment       = PDefault()
  private var _age      : tAge           = ADefault()
  private var _sector   : Sector         = SDefault()
  private var _cargo    : Title          = TDefault()
  private var _graduate : List[Graduate] = List(GDefault())
  private var _genre    : tGenre         = GenreDefault()

  def getName     : tName           = name
  def getCPF      : tCPF            = cpf
  def getFirstDay : Date           = firstDay
  def getId       : tId            = _id

  def getBorndate : Date           = _bornDate
  def getPayment  : tPayment       = _payment
  def getAge      : tAge           = _age
  def getSector   : Sector         = _sector
  def getCargo    : Title          = _cargo
  def getGraduate : List[Graduate] = _graduate
  def getGenre    : tGenre         = _genre

  def setBorndate(s: Date)    : Unit = {
    s.verify() match {
      case None       => throw InvalidArgument("ERRO: Entrada não é uma data")
      case Some(bool) =>
        if(!bool) throw InvalidArgument("ERRO: Data inserida não é válida")
        else _bornDate = s
    }
  }
  def setPayment (s: String)  : Unit = {
    val payment = Payment(s,this._cargo)

    payment.verify() match {
      case None        => throw InvalidArgument("ERRO: Salário Atribuído não é um número.")
      case Some(bool)  =>
        if(!bool) throw InvalidArgument("ERRO: Salário atribuído não condiz com o cargo")
        else _payment = payment
    }
  }
  def setAge     (s: String)  : Unit = {
    val age = Age(s)

    age.verify() match {
      case None       => throw InvalidArgument("ERRO: Idade atribuida não é um número")
      case Some(bool) =>
        if(!bool) throw InvalidArgument("ERRO: Idade não permitida no hall de funcionários.")
        else _age = age
    }
  }
  def setSector  (s: Sector)  : Unit = {
//    s.verify(this._graduate) match {
//      case None       => throw InvalidArgument("ERRO: Setor não encontrado.")
//      case Some(bool) =>
//        if(!bool) throw InvalidArgument("ERRO: Setor atribuído não condiz com a graduação.")
//        else _sector = s
//  }
  }
  def setCargo   (s: Title)   : Unit = {
    s.verify(this._graduate)  match {
      case None       => throw InvalidArgument("ERRO: Titulo não encontrado")
      case Some(bool) =>
        if(!bool) throw InvalidArgument("ERRO: Título não condiz com a graduação.")
        else _cargo = s
    }
  }
  def setGraduate(s: Graduate): Unit = {
    if(_graduate == List(GDefault())) _graduate = _graduate.init
    _graduate ::= s
  }
  // .init seleciona os elementos da lista com exceção do ultimo. Portanto, neste caso, remove o objeto GDefault() da lista.

  def setGenre(s: String)      : Unit ={
      s.toLowerCase() match{
        case "male" => _genre = Male()
        case "female" => _genre = Female()
        case  "masculino" => _genre = Male()
        case  "feminino" => _genre = Female()
        case _ => _genre = GenreDefault()
      }
  }

}
