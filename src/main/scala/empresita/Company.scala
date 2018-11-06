package empresita

import java.util.Date

import empresita.sectors._
import empresita.positions._

class Company(name: String) {

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

//  def hire(person: Person, sector: String, position: Position): Employee = {
//    val sec = this.sectors.getSector(sector)
//    hire(person, sec, position)
//  }
//
//  def hire(name: String, CPF: String, birthday: Date, qualification: Qualification, sector: Sector, position: Position): Employee = {
//    val pers = new Person(name, CPF, birthday, qualification)
//    hire(pers, sector, position)
//  }
//
//  def hire(name: String, CPF: String, birthday: Date, qualification: Qualification, sector: String, position: Position): Employee = {
//    val sec = this.sectors.getSector(sector)
//    val pers = new Person(name, CPF, birthday, qualification)
//    hire(pers, sec, position)
//  }


  def fire(emp: Employee): Unit ={
    emp.sector.remove_emp(emp.CPF)
  }

  def empsSalaryMean(): Double = {
    sectors.meanSalaryEmployees()
  }

  def sectorsSalaryMean(): Double = {
    sectors.meanSalarySectors()
  }

}

