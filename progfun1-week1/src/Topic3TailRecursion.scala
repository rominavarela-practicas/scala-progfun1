

object Topic3TailRecursion {
  def factorial(x:Double):Double = {
    def _loop(x:Double, accum:Double):Double = {
      if (x <= 0) accum
      else _loop(x - 1, x * accum)
    }
    _loop(x - 1, x)
  }
  
  def apply() {
    println("Topic 3")
    println("Tail Recurssion and Termination")
    println("If a function calls it's self as its last action, the function's stack frame can be reused.")
    println()
    
    val x = 5.0
    val fact = factorial(x)
    
    println(s"x = ${x}")
    println(s"factorial = ${fact}")
  }
}