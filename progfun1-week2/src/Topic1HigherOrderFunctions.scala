

object Topic1HigherOrderFunctions {
  def mapReduce( combineFunc: (Int, Double) => Double ): (Int, Int) => Double = {
    def loop(a:Int, b:Int, accum:Double = 0):Double = {
      if(a > b) accum
      else loop(a+1, b, combineFunc(a, accum))
    }
    return(a:Int, b:Int) => loop(a,b,0)
  }
  
  def factorial = mapReduce(combineFunc = (n:Int, accum:Double) => {
    if(accum > 0) n * accum
    else n
  });
  
  def apply() {
    println("Topic 1")
    println("Higher Order Functions")
    println("Functions that take other functions as parameters or that return functions as results.")
    
    val n = 5
    val ans1 = mapReduce( (n:Int, accum:Double) => n + accum )(1,n)
    val ans2 = factorial(1,n)
    
    println(s"n = ${n}")
    println(s"summatory = ${ans1}")
    println(s"factorial = ${ans2}")
  }
}