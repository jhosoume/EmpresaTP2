package empresita

import empresita.positions._
import empresita.sectors._
import java.util.Date

object Main extends App {
  val myCom = new Company("Monsters Inc")
  val myCom2 = new Company("Tigus")
  println("¡Hola, mundo!")
  val eu = new Person(name = "It's me, Mario", CPF = "1", age = 2,
    birthday = new Date(5/11/1970), qualification = BasicSchooling)
  val eu2 = new Employee(name = "June", CPF = "1", age = 2, birthday = new Date(14/8/1995),
    company = myCom, join_date = new Date(), sector = new Design, position = Assistant, qualification = Admin)
  println(eu2.getName)
  println(eu.getName)
  Hierarchy.next_pos(ExecutiveDirector)

}
