package empresita.sectors
import empresita.{ComputerEngineer, Employee, InformationEngineer, SystemEngineer}

class Tech extends Sector {
  override val name: String = "Tech"
  override def valid_employee(emp: Employee): Boolean = {
    List(ComputerEngineer, SystemEngineer, InformationEngineer).contains(emp.qualification)
  }

}
