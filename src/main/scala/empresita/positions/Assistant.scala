package empresita.positions
import empresita.Employee

object Assistant extends Position {
  override val hierarchy: Int = 1
  override val commute_voucher: Float = 350
  override val salary: Double = 1500


  override def has_requirements(emp: Employee): Boolean = {
    true
  }

}
