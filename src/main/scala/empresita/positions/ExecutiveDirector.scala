package empresita.positions
import empresita.{Employee, Qualification}

object ExecutiveDirector extends Director {
  override val hierarchy: Int = 6
  override val salary: Double = 18000

  override def has_requirements(emp: Employee): Boolean = {
    true
  }
}
