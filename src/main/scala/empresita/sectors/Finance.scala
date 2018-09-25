package empresita.sectors
import empresita.{Admin, Employee}

class Finance extends Sector {
  override def valid_employee(emp: Employee): Boolean = {
    List(Admin, ).contains(emp.qualification)

  }

}
