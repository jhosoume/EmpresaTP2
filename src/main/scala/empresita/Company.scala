package empresita

import java.time.LocalDate
import java.util.Date

import empresita.sectors._
import empresita.positions._

class Company(name: String) {

  var sectors: SectorContainer = new SectorContainer

  var op_director: Employee = _
  var exec_director: Employee = _

  def add_emp_to_sector(employee: Employee, sector_name: String):Unit={
    val sector = sectors.getSector(sector_name)
    if (sector.valid_employee(employee)) sector.add_emp(employee)
  }

  def hire(person: Person, sector: Sector, position: Position): Unit ={
    val emp = new Employee(person.name, person.CPF, person.birthday, person.qualification,
      this, new Date(), sector, position)

    sector.add_emp(emp)
  }

  def fire(empCPF: String): Unit ={

  }

}

