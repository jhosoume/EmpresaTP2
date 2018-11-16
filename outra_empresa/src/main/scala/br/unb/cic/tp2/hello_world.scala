package br.unb.cic.tp2

import br.unb.cic.tp2.atributos._
import br.unb.cic.tp2.classes.{DataAcessObject, EmployeeClass}
import br.unb.cic.tp2.traits._

object hello_world extends App {

  val test = new EmployeeClass(Name("Gabriel Nunes Rodrigues Fonseca"),CPF("03783413130"),FirstDay(17,9,2018))

  test.setAge("19")
  test.setBorndate(BornDate(3,1,1999))
  test.setGraduate(ComputerEng())
  test.setCargo(TProfessional())
  test.setPayment("16500")
  test.setSector(STechnology())

  //test.setGenre(Female())
  test.getGenre match {
    case Male() => println("É homem")
    case Female() => println("É mulher")
    case GenreDefault() => println("Vazio")
  }
  DataAcessObject.print(test)
  DataAcessObject.transfer_emp(test, "/home/jhosoume/unb/tp2/empresita/inputs/")
}