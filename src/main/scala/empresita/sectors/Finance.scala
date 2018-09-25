package empresita.sectors
import empresita.{Account, Admin, Economist, Employee}

class Finance extends Sector {
  override def valid_employee(emp: Employee): Boolean = {
    List(Admin, Account, Economist).contains(emp.qualification)

  }

}
