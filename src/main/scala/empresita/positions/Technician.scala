package empresita.positions
import empresita.Employee

object Technician extends Position {
  override val hierarchy: Int = 2

  override def has_requirements(emp: Employee): Boolean = {
    return true
  }
}
