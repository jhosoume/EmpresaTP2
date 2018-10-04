package empresita.sectors

import empresita.Employee
import empresita.positions.{Position, SectorDirector, Pro}

trait Sector {
  var emps: Set[Employee] = Set[Employee]()
  var director: Employee = null//TODO guarantee that the director is part of the sector
  val name: String

  def emps_names(): Set[String] = {
    emps.map(_.name)
  }

  def emps_CPF(): Set[String] = {
    emps.map(_.CPF)
  }

  def change_director(newDirector: Employee, newPosition: Position = null): Unit = {
    if (newDirector.sector == this) {
      if (director != null) {
        if (newPosition != null)
          director.promote(newPosition)
        else {
          director.position = Pro
        }
      }
      director = newDirector
      newDirector.position = SectorDirector
    } else {
      throw new InvalidSectorException("Employee does not belong to sector")
    }
  }

  def num_employee(): Int = emps.size

  def valid_employee(emp: Employee): Boolean

  @throws(classOf[InvalidSectorException])
  def add_emp(emp: Employee): Unit = {
    if (valid_employee(emp) || !List(Pro, SectorDirector).contains(emp.position)) {
      emps += emp
      if (emp.position == SectorDirector) {
        change_director(emp)
      }
    } else {
      throw new InvalidSectorException("Employee does not satisfy sector requirements.")
    }
  }

  def remove_emp(empCPF: String): Unit = {
    emps = emps.filterNot(emp => emp.CPF == empCPF)
    if (emps.find(_.CPF == empCPF).get == director)
      director = null
  }

  def has_employee(empCPF: String): Boolean = {
    emps.exists(emp => emp.CPF == empCPF)
  }

  @throws(classOf[Exception])
  def getEmployee(empCPF: String): Employee = {
    emps.find(_.CPF == empCPF).orNull
  }

  def salaryAvg(): Double = {
    if(num_employee() <= 0) {
      0.0
    } else emps.toList.map(x => getEmployee(x.CPF).salary()).sum / emps.size

  }
}
