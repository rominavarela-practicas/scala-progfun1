

object Topic4Termination {
  def abs(x:Double) = if(x >= 0) x else -x
  
  def square(x:Double) = x * x
  
  def initialGuess(x:Double, accum:Double = 1):Double = {
    if(square(accum) > x) accum
    else initialGuess(x, accum + 1)
  }
  
  def hasntChanged(prev:Double, next:Double):Boolean = {
    prev == next
  }
  
  def squareRoot(x:Double, guess:Double, precision:Double):Double = {
    if(abs( x - square(guess) ) <= precision){
      guess
    }
    else {
      val nextGuess = (guess + x/guess)/2
      if(hasntChanged(guess, nextGuess)) guess
      else squareRoot(x, nextGuess , precision)
    }
  }
  
  def apply() {
    println("Topic 4")
    println("Termination")
    println("Very small or very large numbers might tend to unreachable approximations, non termination cases should be deviced and avoided.")
    println()
    
    val x = 2.0
    val precision = 1e-20
    val sqrt = squareRoot(x, initialGuess(x), precision)
    
    println(s"x = ${x}")
    println(s"precision = ${precision}")
    println(s"final precision = ${abs( x - square(sqrt) )}")
    println(s"sqrt = ${sqrt}")
  }
}