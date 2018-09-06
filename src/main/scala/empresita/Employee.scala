package empresita

import java.util.Date

import empresita.positions.Position
import empresita.sectors.Sector

class Employee(name: String, CPF: String, age: Int,
               company_id: Int, var salary: Float, join_date: Date,
               var sector: Sector, var position: Position) extends Person(name, CPF, age) {

  def raise_salary(raise: Float): Unit = {}
  def promote(): Unit = {}

}
