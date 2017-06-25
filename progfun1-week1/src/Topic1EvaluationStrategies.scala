

object Topic1EvaluationStrategies {
  def square(x:Double) = x * x
  
  def squareFirstByName(x: => Double, y: => Double) = square(x)
  
  def squareFirstByValue(x:Double, y:Double) = square(x)
  
  def longComputedValue:Double = {
    Thread.sleep(3000)
    return 3
  }
  
  def apply() {
  println("Topic 1")
  println("Evaluation Strategies")
  println("A substitution model defines how an expression is reduced to a value.")
  println("- Call by name does not evaluate params until they are required in the end")
  println("- Call by value evaluates all params first")
  println()
    
  println("Call by name...")
  val calledByName = squareFirstByName(2, longComputedValue)
  println(calledByName)
  
  
  println("Call by value...")
  val calledByValue = squareFirstByValue(2, longComputedValue)
  println(calledByValue)
  }
}