package empresita.positions
import empresita.Employee

object Technician extends Position {
  override val hierarchy: Int = 2
  override val commute_voucher: Float = 350
  override val salary: Double = 3000

  override def has_requirements(emp: Employee): Boolean = {
    true
  }
}
