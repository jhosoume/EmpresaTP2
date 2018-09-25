package empresita.positions
import empresita.Employee

object SectorDirector extends Director {
  override val hierarchy: Int = 4

  override def has_requirements(emp: Employee): Boolean = {
    return true
  }
}
