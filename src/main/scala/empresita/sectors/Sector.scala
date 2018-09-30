package empresita.sectors

import empresita.Employee
import empresita.positions.{Position, SectorDirector}

trait Sector {
  var emps: Set[Employee] = Set[Employee]()
  var director: Employee = _//TODO guarantee that the director is part of the sector
  val name: String

  def change_director(newDirector: Employee, newPosition: Position = null): Unit ={
    if(director != null) {
      if (newPosition != null) {
        director.promote(newPosition)
      } else {
        director.demote() //TODO assess if there are any problems with qualification
      }
    }
    newDirector.promote(SectorDirector)
    director = newDirector
  }

  def num_employee(): Int = emps.size

  def valid_employee(emp: Employee): Boolean

  def add_emp(emp: Employee): Unit = {
    if (valid_employee(emp))
      emps += emp
    //else TODO throw InvalidEmployeeException
  }

  def remove_emp(empCPF: String): Unit = {
    emps = emps.filterNot(emp => emp.CPF == empCPF)
    if(emps.find(_.CPF == empCPF).get.position == director)
      director = null
  }

  def has_employee(empCPF: String): Boolean = {
    emps.exists(emp => emp.CPF == empCPF)
  }

  def getEmployee(empCPF: String): Employee = {
    emps.find(_.CPF == empCPF).get
  }

  def salaryAvg(): Double ={
    if(num_employee()==0)
      0
    else emps.map(x => getEmployee(x.CPF).salary()).sum/emps.size
  }
}
