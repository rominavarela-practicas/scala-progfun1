

object Main extends App {
  def hr = println("\n----------\n")
  
  println("Topic 1")
  println("Lists and Tuples")
  val unsorted = 8 :: 2 :: 1 :: 4 :: 9 :: 3 :: 5 :: 7 :: 6 :: Nil
  val sorted = MergeSort.sort(unsorted)
  println("unsorted" + " " + unsorted)
  println("sorted" + " " +sorted)
}