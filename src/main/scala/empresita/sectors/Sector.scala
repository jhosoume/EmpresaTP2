package empresita.sectors

import empresita.Employee

trait Sector {
  var emps: List[Employee] = _
  var director: Employee = _
  val name: String

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
}
