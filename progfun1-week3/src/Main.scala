import presistent.binary_tree.EmptyLeaf
import scala.util.Random

object Main extends App {
  println("Class Hierarchies and Polmorphism")
  println("- Classes can 'extend' one Trait or Abstract Class 'with' various Traits")
  println("- Classes can be instantiated. Objects are singleton Classes.")
  println("- Classes and Abstract Classes can have fields (def) and params (val, var). Traits can only have fields.")
  
  val pairs = EmptyLeaf + 2 + 4 + 6 + 8 + 10
    
  val nones = EmptyLeaf + 1 + 3 + 5 + 7 + 9
    
  val primes = EmptyLeaf + 2 + 3 + 5 + 7
  
  println(s"Pairs contains 5 ? ${ pairs contains 5 }")
  println(s"Pairs u Nones contains 5 ? ${(pairs u nones) contains 5 }")
  
  println(s"Nones n Primes contains 5 ? ${(nones n primes) contains 5 }")
  println(s"Nones n Primes contains 9 ? ${(nones n primes) contains 9 }")
}