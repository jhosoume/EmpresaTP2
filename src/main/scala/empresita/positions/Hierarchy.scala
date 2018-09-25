package empresita.positions

object Hierarchy {

  val positions = List(Assistant, Technician, Pro, SectorDirector, OperationDirector, ExecutiveDirector)
  def next_pos(pos: Position): Position = {
    if (pos == ExecutiveDirector) {
      return ExecutiveDirector
    }
    val indx = positions.zipWithIndex.find(_._1 == pos).map(_._2).get + 1
    return positions(indx)
  }

}
