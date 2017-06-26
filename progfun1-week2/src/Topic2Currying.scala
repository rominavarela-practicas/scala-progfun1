

object Topic2Currying {
  def mapReduce( combineFunc: (Int, Double) => Double )(a:Int, b:Int): Double = {
    def loop(a:Int, b:Int, accum:Double = 0):Double = {
      if(a > b) accum
      else loop(a+1, b, combineFunc(a, accum))
    }
    return loop(a,b,0)
  }
  
  def factorial = mapReduce((n:Int, accum:Double) => {
    if(accum > 0) n * accum
    else n
  })(_,_);
  
  def apply() {
    println("Topic 2")
    println("Currying")
    println("When a method is called with fewer parameters, this will yield a function taking the missing parameters as its arguments.")
    
    val n = 5
    val ans1 = mapReduce( (n:Int, accum:Double) => n + accum )(1,n)
    val ans2 = factorial(1,n)
    
    println(s"n = ${n}")
    println(s"summatory = ${ans1}")
    println(s"factorial = ${ans2}")
  }
}