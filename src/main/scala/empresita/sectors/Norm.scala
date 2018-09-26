package empresita.sectors
import empresita.{Account, Communication, Employee, Lawyer}

class Norm extends Sector {
  override val name: String = "Norm"
  override def valid_employee(emp: Employee): Boolean = {
    List(Lawyer, Communication, Account).contains(emp.qualification)
  }
}
