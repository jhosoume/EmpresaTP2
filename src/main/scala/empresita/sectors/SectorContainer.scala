package empresita.sectors

import empresita.Employee

class SectorContainer {
  var finance = new Finance
  var design = new Design
  var marketing = new Marketing
  var norm = new Norm
  var tech = new Tech

  def getSector(name: String): Sector = {
    val attr = this.getClass.getDeclaredField(name.toLowerCase)
    attr.setAccessible(true)
    attr.get(this).asInstanceOf[Sector]
  }

  def sectorsObjs(): Set[Sector] = {
    val attrs = this.getClass.getDeclaredFields
    var sectors: Set[Sector] = Set[Sector]()
    for (at <- attrs ) {
      at.setAccessible(true)
      sectors += at.get(this).asInstanceOf[Sector]
    }
    sectors
  }

  def size(): Int = {
    sectorsObjs().size
  }

  def meanSalarySectors(): Double = {
    if (size() <= 0) {
      0.0
    } else {
      sectorsObjs().toList.map(_.salaryAvg()).sum / size()
    }
  }

  def allEmps(): Set[Employee] = {
    sectorsObjs().flatMap(_.emps)
  }

  def numEmps(): Int = {
    sectorsObjs().flatMap(_.emps).size
  }


  def meanSalaryEmployees(): Double = {
    val nEmp = numEmps()
    if (nEmp <= 0) {
      0.0
    } else {
      allEmps().toList.map(_.salary()).sum / nEmp
    }
  }
}
