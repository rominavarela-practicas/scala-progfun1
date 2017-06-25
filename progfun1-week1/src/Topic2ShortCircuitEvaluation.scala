

object Topic2ShortCircuitEvaluation {
  def and(a:Boolean, b:Boolean) = {
    if(a) b else false
  }
  
  def or(a:Boolean, b:Boolean) = {
    if(a) a else b
  }
  
  def apply() {
    println("Topic 2")
    println("Short Circuit Evaluation")
    println("Reduction rules behind boolean expressions do not always need their right operand to be evaluated.")
    println()
    
    
    println( s"true and true = ${and(true,true)}" )
    println( s"true and false = ${and(true,false)}" )
    println( s"true or false = ${or(true,false)}" )
  }
}