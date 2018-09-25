package empresita.positions
import empresita.Employee

object Assistant extends Position {
  val hierarchy = 1

  override def has_requirements(emp: Employee): Boolean = {
    return true

  }

}
