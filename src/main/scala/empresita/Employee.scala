package empresita

import java.util.Date

import empresita.positions.{Hierarchy, Position, SectorDirector}
import empresita.sectors.Sector

class Employee(name: String, CPF: String, birthday: Date, qualification: Qualification,
               var company: Company, var join_date: Date,
               var sector: Sector, var position: Position)
  extends Person(name, CPF, birthday, qualification) {

  sector.add_emp(this)

  var raise_salary: Double = 0

  def promote(new_position: Position = null): Unit = {
    if (new_position == SectorDirector) {
      sector.change_director(this)
    } else {
      if (new_position != null) position = new_position
      else position = Hierarchy.next_pos(position)
    }
  }

  def demote(): Unit ={
    position = Hierarchy.prev_pos(position)
  }

  def change_sector(newSector: Sector) : Unit = {
    sector.remove_emp(CPF)
    newSector.add_emp(this)
    sector = newSector
  }

  def salary(): Double = {(position.salary+position.commute_voucher)*position.bonus+raise_salary}


}
