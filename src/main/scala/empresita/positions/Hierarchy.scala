package empresita.positions

object Hierarchy {

  val positions = List(Assistant, Technician, Pro, SectorDirector, OperationDirector, ExecutiveDirector)
  def next_pos(pos: Position): Position = {
    if (pos == ExecutiveDirector) {
      ExecutiveDirector
    }
    val indx = positions.zipWithIndex.find(_._1 == pos).map(_._2).get + 1
    positions(indx)
  }
  def prev_pos(pos: Position): Position = {
    if (pos == Assistant) {
      Assistant
    }
    val indx = positions.zipWithIndex.find(_._1 == pos).map(_._2).get - 1
    positions(indx)
  }

}
