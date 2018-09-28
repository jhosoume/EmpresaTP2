package empresita

import java.text.{DateFormat, SimpleDateFormat}
import java.time.{LocalDate, Period, ZoneId}

import empresita.positions._
import empresita.sectors._
import java.util.Date

object Main extends App {
  val format = new SimpleDateFormat("dd-MM-yyyy")

  val myCom = new Company("Monsters Inc")
  val myCom2 = new Company("Tigus")
  println("¡Hola, mundo!")
  val eu = new Person(name = "It's me, Mario", CPF = "1",
    birthday = format.parse("03-02-1962"), qualification = BasicSchooling)
  val eu2 = new Employee(name = "June", CPF = "1", birthday = format.parse("14-08-1995"),
    company = myCom, join_date = new Date(), sector = new Design, position = Assistant, qualification = Admin)
  println(eu2.getName)
  println(eu.getName)
  Hierarchy.next_pos(ExecutiveDirector)
  println(eu.birthday)
  println(eu.age)
  println(LocalDate.now)

}
