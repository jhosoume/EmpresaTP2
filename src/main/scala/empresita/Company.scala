package empresita

import empresita.sectors._

import scala.collection.mutable

class Company(name: String) {

  var sectors: SectorContainer = new SectorContainer

  var op_director: Employee = _
  var exec_director: Employee = _

  def add_emp_to_sector(employee: Employee, sector_name: String): Unit = {
    val sector = sectors.getSector(sector_name)
    if (sector.valid_employee(employee)) sector.add_emp(employee)
  }

  def change_sector(emp_name: String) : Unit = {

  }

}

