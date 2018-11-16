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
  DataAcessObject.transfer_emp(test, "C:\\Luisa\\UnB\\2018-02\\TP2\\empresita\\inputs\\")

  //TODO TESTE2
  val test2 = new EmployeeClass(Name("Luisa Sinzker Fantin"),CPF("11122233300"),FirstDay(6,10,2017))

  test2.setAge("23")
  test2.setBorndate(BornDate(14,8,1995))
  test2.setGraduate(ComputerEng())
  test2.setCargo(TProfessional())
  test2.setPayment("16500")
  test2.setSector(STechnology())

  //test.setGenre(Female())
  test2.getGenre match {
    case Male() => println("É homem")
    case Female() => println("É mulher")
    case GenreDefault() => println("Vazio")
  }
  DataAcessObject.print(test2)
  DataAcessObject.transfer_emp(test2, "C:\\Luisa\\UnB\\2018-02\\TP2\\empresita\\inputs\\")

  //TODO TESTE3
  val test3 = new EmployeeClass(Name("Juliana May"),CPF("12345678900"),FirstDay(2,7,2016))

  test3.setAge("26")
  test3.setBorndate(BornDate(1,2,1992))
  test3.setGraduate(ComputerEng())
  test3.setCargo(TProfessional())
  test3.setPayment("16500")
  test3.setSector(STechnology())

  //test.setGenre(Female())
  test3.getGenre match {
    case Male() => println("É homem")
    case Female() => println("É mulher")
    case GenreDefault() => println("Vazio")
  }
  DataAcessObject.print(test3)
  DataAcessObject.transfer_emp(test3, "C:\\Luisa\\UnB\\2018-02\\TP2\\empresita\\inputs\\")
}