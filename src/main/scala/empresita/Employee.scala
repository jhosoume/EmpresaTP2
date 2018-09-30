package empresita

import java.util.Date

import empresita.positions.{Hierarchy, Position}
import empresita.sectors.Sector

class Employee(name: String, CPF: String, birthday: Date, qualification: Qualification,
               var company: Company, var join_date: Date,
               var sector: Sector, var position: Position)
  extends Person(name, CPF, birthday, qualification) {

  var raise_salary: Float = 0

  //TODO add the employee to the employee list of employees in his sector
  //TODO if the employee is a director assign him to the position val

  def promote(new_position: Position = null): Unit = {
    if(new_position != null) position = new_position
    else position = Hierarchy.next_pos(position)
  }

  def change_sector(newSector: Sector) : Unit = {
    newSector.add_emp(this)
    sector.remove_emp(CPF)
    sector = newSector
  }

  def salary(): Double = {(position.salary+position.commute_voucher)*position.bonus+raise_salary}


}
