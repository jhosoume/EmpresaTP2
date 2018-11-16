package br.unb.cic.tp2.classes

import java.io.{File, PrintWriter}

import br.unb.cic.tp2.InvalidArgument
import br.unb.cic.tp2.traits.{DataExib, _}
import br.unb.cic.tp2.atributos._

object DataAcessObject extends DataExib {

  def print(o: Employee) : Unit = {

    val name = o.getName match {
      case Name(v)     => v
      case NDefault(v) => "ENCONTRADO => " + v
      case _           => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getName")
    }

    val cpf  = o.getCPF match {
      case CPF(v)        => v
      case CPFDefault(v) => "ENCONTRADO => " + v
      case _             => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getCPF")
    }

    val firstDay = o.getFirstDay match {
      case FirstDay(d,m,a) => d + "/" + m + "/" + a
      case DDefault(d,m,a) => "ENCONTRADO ERRO: " + d + "/" + m + "/" + a
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getFirstDay")
    }

    val bornDate = o.getBorndate match {
      case BornDate(d,m,a) => d + "/" + m + "/" + a
      case DDefault(d,m,a) => "ENCONTRADO ERRO: " + d + "/" + m + "/" + a
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getBornDate")

    }

    val id = o.getId match {
      case Id(v) => v
      case IdDefault(v)    => "ENCONTRADO => " + v
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getId")

    }

    val payment = o.getPayment match {
      case Payment(v,_) => v
      case PDefault(v) => "ENCONTRADO => " + v
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getPayment")

    }

    val age = o.getAge match {
      case Age(v) => v
      case ADefault(v) => "ENCONTRADO => " + v
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getAge")

    }

    val sector = o.getSector match {
      case SDefault(v) => "ENCONTRADO => " + v
      case v: Sector   => v
      case _           => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getSector")

    }

    val title = o.getCargo match {
      case TDefault(v) => "ENCONTRADO => " + v
      case v: Title    => v
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getCargo")

    }

    println("     DADOS DO FUNCIONÁRIO        ")
    println("Nome: " + name)
    println("Matricula: " + id)
    println("CPF: " + cpf)
    println("Idade: " + age)
    println("Data de nascimento: " + bornDate)
    println("--------------------------------")
    println("Setor: " + sector)
    println("Cargo: " + title)
    println("Pagamento: " + payment)
    println("Na empresa desde de " + firstDay)

  }

  def transfer_emp(emp: Employee, path: String): Unit = {
    val name = emp.getName match {
      case Name(v)     => v
      case NDefault(v) => "ENCONTRADO => " + v
      case _           => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getName")
    }

    val cpf  = emp.getCPF match {
      case CPF(v)        => v
      case CPFDefault(v) => "ENCONTRADO => " + v
      case _             => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getCPF")
    }

    val bornDate = emp.getBorndate match {
      case BornDate(d,m,a) => d + "/" + m + "/" + a
      case DDefault(d,m,a) => "ENCONTRADO ERRO: " + d + "/" + m + "/" + a
      case _               => throw InvalidArgument("Erro absurdo: Não se sabe o que foi encontrado em Employee.getBornDate")

    }

    val pw = new PrintWriter(new File(path + cpf + ".txt"))
    pw.write("Nome : " + name + "\n")
    pw.write("CPF : " + cpf + "\n")
    pw.write("date : " + bornDate)
    pw.close()
  }


  def print(o: Sector)   : Unit = {

  }
}
