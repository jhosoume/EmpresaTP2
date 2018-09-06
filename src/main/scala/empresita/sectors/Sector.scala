package empresita.sectors

import empresita.Employee

trait Sector {
  var emps: List[Employee]
  var director: Employee

  def num_employee(): Int
  def valid_employee(emp: Employee): Boolean
  def add_emp(emp: Employee): Unit
  def remove_emp(name: String): Employee
  def has_employee(name: String): Boolean
}
