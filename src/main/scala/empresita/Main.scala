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
  val eu2 = new Employee(name = "June", CPF = "5", birthday = format.parse("14-08-1995"),
    company = myCom, join_date = new Date(), sector = new Design, position = Assistant, qualification = Admin)

  println(eu2.getName)
  println(eu.getName)
  //Hierarchy.next_pos(ExecutiveDirector)TODO error here*

  val IASA = new Company("IASA")

  val johnC = new Person("John Crichton", "11721812011",
    format.parse("11-12-1962"), SystemEngineer)

  IASA.hire(johnC, IASA.sectors.tech, Pro)

  val aerynS = new Employee("Aeryn Sun", "12325266669",
    format.parse("11-10-1972"), InformationEngineer, IASA, new Date(),
    IASA.sectors.tech, SectorDirector)

  val dummyDesign = new Employee("Dummy Design", "0001",
    format.parse("11-10-1972"), GraphicDesigner, IASA, new Date(),
    IASA.sectors.design, Pro)

  val dummyFinance = new Employee("Dummy Finance", "0002",
    format.parse("11-10-1972"), Admin, IASA, new Date(),
    IASA.sectors.finance, Pro)

  val dummyMark = new Employee("Dummy Marketing", "0003",
    format.parse("11-10-1972"), Communication, IASA, new Date(),
    IASA.sectors.marketing, SectorDirector)

  val dummyNorm = new Employee("Dummy Norm", "0004",
    format.parse("11-10-1972"), BasicSchooling, IASA, new Date(),
    IASA.sectors.norm, Assistant)

  println(IASA.sectors.tech.salaryAvg())
  println(IASA.sectors.design.salaryAvg())
  println(IASA.sectors.design.num_employee())
  println(IASA.salaryAvg())

  

}
