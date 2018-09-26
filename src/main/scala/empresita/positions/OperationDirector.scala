package empresita.positions
import empresita.Employee

object OperationDirector extends Director {
  override val hierarchy: Int = 5
  override val salary: Float = 13000

  override def has_requirements(emp: Employee): Boolean = {
    return true
  }
}
