

object Main extends App {
  def hr = println("\n----------\n")
  val N = 10
  
  println("Topic 1")
  println("Combinatorial search and generators")
  println(FindCombinations.stepByStep(N))
  println(FindCombinations.usingFlatMap(N))
  println(FindCombinations.withGenerator(N))
  
}

