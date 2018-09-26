package empresita

import java.util.Date

import empresita.positions.{Hierarchy, Position}
import empresita.sectors.Sector

class Employee(name: String, CPF: String, age: Int, birthday: Date, qualification: Qualification,
               var company: Company, var join_date: Date,
               var sector: Sector, var position: Position)
  extends Person(name, CPF, age, birthday, qualification) {

  var raise_salary: Float = 0

  def promote(new_position: Position = null): Unit = {
    if(new_position != null) position = new_position
    else position = Hierarchy.next_pos(position)
  }

  def salary(): Double = {position.salary*position.bonus+raise_salary}


}
