package empresita.positions

import empresita.{Employee, Qualification}

trait Position extends Ordered[Position]{
  val hierarchy: Int
  val commute_voucher: Float = 0
  val salary: Double
  val bonus: Double = 1

  def has_requirements(emp: Employee) : Boolean
  def compare(that: Position)= this.hierarchy - that.hierarchy


}
