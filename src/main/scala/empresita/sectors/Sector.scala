package empresita.sectors

import empresita.Employee
import empresita.positions.{Position, SectorDirector}

trait Sector {
  var emps: Set[Employee] = Set[Employee]()
  var director: Employee = _
  val name: String

  def change_director(newDirector: Employee, newPosition: Position = null): Unit ={
    if(director == null)
      newDirector.promote(SectorDirector)
    else {
      if (newPosition != null){
        director.promote(newPosition)
        newDirector.promote(SectorDirector)
      }else{
        //println("Old director needs new position. Aborting.")
        //TODO create an exception NoNewPositionForExDirector
        director.demote()
        //Breaks
      }
    }
    director = newDirector
  }

  def num_employee(): Int = emps.size

  def valid_employee(emp: Employee): Boolean

  def add_emp(emp: Employee): Unit = {
    if (valid_employee(emp))
      emps += emp
    //else TODO throw InvalidEmployeeException
  }
  def remove_emp(emp_cpf: String): Unit = {
    emps = emps.filterNot(emp => emp.CPF == emp_cpf)
  }
  def has_employee(emp_CPF: String): Boolean = {
    emps.exists(emp => emp.CPF == emp_CPF)
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
