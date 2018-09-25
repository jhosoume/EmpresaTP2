package empresita.positions
import empresita.{Employee, Qualification}

object ExecutiveDirector extends Director {
  override val hierarchy: Int = 6

  override def has_requirements(emp: Employee): Boolean = {
    return true
  }
}
