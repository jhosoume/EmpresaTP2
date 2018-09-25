package empresita.sectors
import empresita.{Admin, Communication, Market, Employee}

class Marketing extends Sector {
  override def valid_employee(emp: Employee): Boolean = {
    List(Communication, Admin, Market).contains(emp.qualification)
  }

}
