package empresita.sectors

import empresita.Employee

trait Sector {
  var emps: List[Employee] = _
  var director: Employee = _

  def num_employee(): Int = emps.length
  def valid_employee(emp: Employee): Boolean
  def add_emp(emp: Employee): Unit = {
    if (valid_employee(emp))
      emp :: emps
  }
  def remove_emp(emp_name: String): Unit = {
  }
  def has_employee(name: String): Boolean = true
}
