import natural_numbers.Zero
import presistent.binary_tree.EmptyLeaf

object Main extends App {
  def hr = println("\n----------\n")
  
  println("Topic 1")
  println("Pure Object Orientation")
  println("Scala is a pure-object-oriented language where every function and value is an object")
  println()
  val one = Zero.successor
  
  val two = one + one
  
  val three = one + one + one
  
  val four = one + one + one + one
  
  val five = one + one + one + one + one
  
  println(s"two + two == four ? ${ two + two == four }")
  println(s"five - one == four ? ${ five - one == four }")
  println(s"five - one == three ? ${ five - one == three }")
  println(s"(five - (two + three)) == Zero ? ${ (five - (two + three)) == Zero }")
  
  hr
  
  println("Topic 2")
  println("Variance and Pattern Matching")
  println("- To covariant / child classes are notated as +AnyValSub <: AnyVal")
  println("- To contravariant / parent classes are notated as -AnyValSuper >: AnyVal")
  println("- Decomposition recovers what kind of constructor was used for a value")
  println("- Patterns can be variables (x:Int), constants (1), constructors (Sum(a,b)) and wildcards (_)")
  println()
  
  val anyValTree = EmptyLeaf + 3 + 2f + 40 + 'z' + 8 + 1e3
  
  println(anyValTree)
  
}