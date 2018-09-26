package empresita.sectors
import empresita.{Employee, GraphicDesigner, MultimediaDesigner, SocialEngineer}

class Design extends Sector {
  override val name: String = "Design"
  override def valid_employee(emp: Employee): Boolean = {
    List(GraphicDesigner, MultimediaDesigner, SocialEngineer).contains(emp.qualification)
  }

}
