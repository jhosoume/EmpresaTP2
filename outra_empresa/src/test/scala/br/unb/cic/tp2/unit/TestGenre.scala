package br.unb.cic.tp2.unit
import br.unb.cic.tp2.atributos.{CPF, FirstDay, Name}
import br.unb.cic.tp2.traits._
import br.unb.cic.tp2.classes.EmployeeClass
import org.scalatest.{BeforeAndAfter, FlatSpec, GivenWhenThen, Matchers}

class TestGenre extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{
  behavior of "Employee"
  var name = Name("Breno")
  var cpf = CPF("00000000000")
  var day1 = FirstDay(1, 9, 2011)
  var empregado = new EmployeeClass(name,cpf,day1)
  it should "MASCULNO have to get genre = MALE()" in {
    empregado.setGenre("MASCULINO")
    empregado.getGenre should be (Male())
  }
  it should "FEMiNINO have to get genre = Female() " in {
    empregado.setGenre("FEMiNINO")
    empregado.getGenre should be (Female())
  }
  it should "MALe have to get genre = Male()" in{
    empregado.setGenre("MALe")
    empregado.getGenre should be (Male())
  }
  it should "FeMaLe have to get genre = Female()"in{
    empregado.setGenre("FeMaLe")
    empregado.getGenre should be (Female())
  }
  it should "M have to get genre = GenreDefualt()" in{
     empregado.setGenre("M")
     empregado.getGenre should be (GenreDefault())
  }
}
