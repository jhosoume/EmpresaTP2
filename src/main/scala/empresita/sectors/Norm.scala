package empresita.sectors
import empresita.{Account, Communication, Employee, Lawyer}

class Norm extends Sector {
  override def valid_employee(emp: Employee): Boolean = {
    List(Lawyer, Communication, Account).contains(emp.qualification)
  }
}
