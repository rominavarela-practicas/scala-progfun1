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
  println("Variance, Pattern Matching and Right Associativity")
  println("- To covariant / child classes are notated as +AnyValSub <: AnyVal")
  println("- To contravariant / parent classes are notated as -AnyValSuper >: AnyVal")
  println("- Decomposition patterns can be variables (x:Int), constants (1), constructors (Sum(a,b)) (head :: tail) and wildcards (_)")
  println("- By convention in scala, operators ending in ':' are applied to the right.")
  println()
  
  val anyValTree1 =  EmptyLeaf.::(3).::(2f).::('z').::(10).::(1e3)
  val anyValTree2 =  1e3 :: 10 :: 'z' :: 2f :: 3 :: EmptyLeaf
  
  println(anyValTree1)
  println(anyValTree2)
  
}