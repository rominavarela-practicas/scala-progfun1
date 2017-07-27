

object Main extends App {
  def hr = println("\n----------\n")
  val N = 10
  
  println("Topic 1")
  println("Combinatorial search and generators")
  println(FindCombinations.stepByStep(N))
  println(FindCombinations.usingFlatMap(N))
  println(FindCombinations.withGenerator(N))
  
  hr
  
  println("Topic 2")
  println("N Queens problem")
  val boardSize = 8
  NQueens.arrange(boardSize).take(4).foreach { board =>
    board.foreach(queenPosition => {
      (0 until boardSize).foreach { position =>
        if(position == queenPosition) print('▓')
        else print('░')
        print(' ')
      }
      println()
    })
    println()
  }
  
}

