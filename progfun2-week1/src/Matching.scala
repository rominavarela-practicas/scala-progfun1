

object Matching {
  def patternMatchingExample() {
    println("Pattern Matching Example")
    println()
    val matcher1:(String => String) = {
      case "ping" => "pong"
    }
    
    try {
      println("Matcher defined for 'ping': " + matcher1("ping"))
      println("Matcher defined for 'abc': " + matcher1("abc"))
    } catch {
      case e:Exception => {
        println("error: " + e.getMessage)
      }
    }
  }
  
  def partialFunctionsExample() {
    println("Partial Function Example")
    println("- Trait PartialFunction[-A,+R]")
    println()
    
    val matcher2:PartialFunction[String,String] = {
        case "ping" => "pong"
    }
    
    try {
      println("Matcher defined for argument 'ping'? " + matcher2.isDefinedAt("ping"))
      println("Matcher defined for argument 'abc'? " + matcher2.isDefinedAt("abc"))
    } catch {
      case e:Exception => {
        println("error: " + e.getMessage)
      }
    }
  }
}