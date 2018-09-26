package empresita.sectors

class SectorContainer {
  var finance = new Finance
  var design = new Design
  var marketing = new Marketing
  var norm = new Norm
  var tech = new Tech

  def getSector(name: String): Sector = {
    val attr = this.getClass.getDeclaredField(name)
    attr.setAccessible(true)
    return attr.get(this).asInstanceOf[Sector]
  }
}
