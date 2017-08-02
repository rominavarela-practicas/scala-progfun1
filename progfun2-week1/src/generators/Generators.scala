package generators

import scala.util.Random

object Generators {
  def showcase() = {
    println("Generators")
    
    println()
    println("numbers:")
    println()
    
    for {
      i <- NumberGenerator
    } println(i)
    
    println()
    println("booleans:")
    println()
    
    for {
      b <- BooleanGenerator
    } println(b)
    
    println()
    println("vowels:")
    println()
    
    val VowelGenerator = OneOfGenerator('a','e','i','o','u')
    
    for {
      v <- VowelGenerator
    } println(v)
  }
  
  def NumberGenerator = new Generator[Int] {
    def generate = Random.nextInt()
  }
  
  def BooleanGenerator = new Generator[Boolean] {
    def generate = (Random.nextInt() % 2) == 0
  }
  
  def OneOfGenerator[T](xs:T*) = new Generator[T] {
    def generate = xs(Random.nextInt(xs.size))
  }
  
}