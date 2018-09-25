package empresita.sectors
import empresita.{ComputationEngineer, Employee, InformationEngineer, SystemEngineer}

class Tech extends Sector {
  override def valid_employee(emp: Employee): Boolean = {
    List(ComputationEngineer, SystemEngineer, InformationEngineer).contains(emp.qualification)
  }

}
