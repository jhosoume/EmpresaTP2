package empresita

import empresita.positions._
import java.util.Date

object Main extends App {
  val myCom = new Company("Monsters Inc")
  println("¡Hola, mundo!")
  val eu = new Person(name ="It's me, Mario", CPF = "1", age = 2)
  val eu2 = new Employee(name = "June", CPF = "1", age = 2, company = myCom, salary = 0,
    join_date = new Date(), sector = _, position = Assistant, qualification = Admin)
  println(eu2.getName)
  println(eu.getName)
  Hierarchy.next_pos(ExecutiveDirector)

}
