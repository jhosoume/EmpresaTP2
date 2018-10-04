package empresita.positions
import empresita.Employee

object Pro extends Position {
  override val hierarchy: Int = 3
  override val salary: Double = 6500

  override def has_requirements(emp: Employee): Boolean = {
    return true
  }
}
