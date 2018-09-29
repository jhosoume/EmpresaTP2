package empresita.sectors

import empresita.Employee
import empresita.positions.{Position, SectorDirector}
import scala.util.control._

trait Sector {
  var emps: List[Employee] = _
  var director: Employee = _
  val name: String

  def change_director(newDirector: Employee, newPosition: Position): Unit ={
    if(director == null)
      newDirector.promote(SectorDirector)
    else {
      if (newPosition != null){
        director.promote(newPosition)
        newDirector.promote(SectorDirector)
      }else {
        println("Old director needs new position. Aborting.")
        Breaks
      }
    }
    director = newDirector
  }

  def num_employee(): Int = emps.length

  def valid_employee(emp: Employee): Boolean

  def add_emp(emp: Employee): Unit = {
    if (valid_employee(emp))
      emp :: emps
  }
  def remove_emp(emp_cpf: String): Unit = {
    emps = emps.filterNot(emp => emp.CPF == emp_cpf)
  }
  def has_employee(emp_CPF: String): Boolean = {
    emps.exists(emp => emp.CPF == emp_CPF)
  }

  def getEmployee(empCPF: String){
    if (emps.exists(emp => emp.CPF == empCPF)){
      emps.find(_.CPF == empCPF)
    }
  }
}
