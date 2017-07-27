

object NQueens {
  def arrange(N:Int): Iterable[List[Int]] = {
    arrange(N, List())
  }
  
  private def arrange(N:Int, fixedPositions:List[Int]): Iterable[List[Int]] =
    if(N == fixedPositions.size) {
      fixedPositions :: Nil
    }
    else (0 until N).collect {
      case position if !isConflictArea(position, fixedPositions) =>
        arrange(N, fixedPositions :+ position)
    }.flatten
  
  private def isConflictArea(position:Int, fixedPositions:List[Int]): Boolean =
    fixedPositions.zipWithIndex.exists {
      case (fixed, height) => {
        val ydistance = fixedPositions.size - height
        (fixed == position) || (fixed == position + ydistance) || (fixed == position - ydistance)
      }
    }
}