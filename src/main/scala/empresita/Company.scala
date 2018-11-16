package empresita

import java.util.Date

import empresita.sectors._
import empresita.positions._

import scala.util.matching.Regex._
import scala.io.Source
import java.io.{FileNotFoundException, IOException}
import java.text.SimpleDateFormat

import scala.util.matching.Regex

class Company(name: String) {
  val format = new SimpleDateFormat("dd-MM-yyyy")
  var sectors: SectorContainer = new SectorContainer

  var op_director: Employee = _
  var exec_director: Employee = _

  def assign_opDirector(newOp: Employee, newPosition: Position = null): Unit ={
    if(op_director != null){
      if (newPosition != null)
        op_director.promote(newPosition)
      else{
        //TODO demote() wont work for these directors
      }
    }
    op_director = newOp
    newOp.promote(OperationDirector)
  }

  def assign_execDirector(newExec: Employee, newPosition: Position = null): Unit ={
    if(exec_director != null){
      if (newPosition != null)
        exec_director.promote(newPosition)
      else{
        //TODO demote() wont work for these directors
      }
    }
    exec_director = newExec
    newExec.promote(ExecutiveDirector)
  }

  def add_emp_to_sector(employee: Employee, sector: Sector): Unit = {
    if (sector.valid_employee(employee)) sector.add_emp(employee)
  }

  def emps(): Set[Employee] = {
    sectors.sectorsObjs().flatMap(_.emps)
  }

  def emps_names(): Set[String] = {
    sectors.sectorsObjs().flatMap(_.emps_names())
  }

  def hire(person: Person, sector: Sector, position: Position): Employee = {
    new Employee(person.name, person.CPF, person.birthday, person.qualification,
      this, new Date(), sector, position)
  }

  def get_employee(CPF: String): Employee = {
    sectors.sectorsObjs().map(_.getEmployee(CPF)).find(emp => emp != null && emp.CPF == CPF).orNull
  }

  def fire(emp: Employee): Unit ={
    emp.sector.remove_emp(emp.CPF)
  }

  def empsSalaryMean(): Double = {
    sectors.meanSalaryEmployees()
  }

  def sectorsSalaryMean(): Double = {
    sectors.meanSalarySectors()
  }

  def import_emp(CPF: String, path: String, position: Position, sector: Sector): Unit = {
    val name_att : Regex = "(?i).*N[a, o]me.*".r
    val date_att : Regex = "(?i).*dat[a, e].*".r
    val cpf_att : Regex = "(?i).*cpf.*".r
    val date_info : Regex = """.*(\d\d)/(\d\d)/(\d\d\d\d).*""".r
    var name = "Unknwon"
    var date = "01-01-2001"
    var cpf = ""
    try {
      val info = Source.fromFile(path + CPF + ".txt").getLines()
      for (line <- info) {
        var att = line.split(":")
        att(0) match {
          case name_att() => name = att(1).replaceAll("\\s", "")
          case date_att() => date = att(1).replaceAll("\\s", "").replaceAll("/", "-")
          case cpf_att() => cpf = att(1).replaceAll("\\s", "")
          case _ => println(att(0))
//          case _ => println("Attribute in person transfer not recognized")
        }

      }
    } catch {
      case e: FileNotFoundException => println("Couldn't find that file.")
      case e: IOException => println("Got an IOException!")
    }
    val new_person = new Person(name, cpf,
      birthday = format.parse(date), qualification = BasicSchooling)
    this.hire(new_person, sector, position)
  }

}

