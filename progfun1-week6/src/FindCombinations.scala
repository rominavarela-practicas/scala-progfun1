

object FindCombinations {
  def isPair(n:Int):Boolean = {
    n % 2 == 0
  }
  
  def stepByStep(N:Int) = {
    val combinations = (1 until N) map { i =>
      (1 until i) map { j => (i,j)}
    }
    combinations.flatten.filter(i_j => isPair(i_j._1 + i_j._2))
  }
  
  def usingFlatMap(N:Int) = {
    val combinations = (1 until N) flatMap { i =>
      (1 until i) map { j => (i,j)}
    }
    combinations.filter(i_j => isPair(i_j._1 + i_j._2))
  }
  
  def withGenerator(N:Int) = {
    for {
      i <- 1 until N
      j <- 1 until i
      if isPair(i + j)
    } yield (i,j)
  }
}