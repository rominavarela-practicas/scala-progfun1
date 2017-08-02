import generators.Generators

object Main extends App {
  def hr = println("\n----------\n")
  
  Matching.patternMatchingExample()
  
  hr
  
  Matching.partialFunctionsExample()
  
  hr
  
  BookStore.showcase()
  
  hr
  
  Generators.showcase()
}