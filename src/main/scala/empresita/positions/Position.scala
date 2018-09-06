package empresita.positions

import empresita.Employee

trait Position {
  def has_requirements(emp: Employee) : Boolean

}
