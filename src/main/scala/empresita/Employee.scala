package empresita

import java.util.Date

import empresita.positions.Position
import empresita.sectors.Sector

class Employee(name: String, CPF: String, age: Int,
               var company: Company, var salary: Float, var join_date: Date,
               var sector: Sector, var position: Position, var qualification: Qualification)
  extends Person(name, CPF, age) {

  def raise_salary(raise: Float): Unit = {}
  def promote(): Unit = {}

}
