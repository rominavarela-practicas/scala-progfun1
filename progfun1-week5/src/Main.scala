

object Main extends App {
  def hr = println("\n----------\n")
  
  println("Topic 1")
  println("Lists and Tuples")
  val unsorted = 8 :: 2 :: 1 :: 4 :: 9 :: 3 :: 5 :: 7 :: 6 :: Nil
  val sorted = MergeSort.sort(unsorted)
  println("unsorted " + unsorted)
  println("sorted " +sorted)
  
  hr
  
  println("Topic 2")
  println("Higher order lists functions")
  println("- partition = (filter, filterNot)")
  println("- span = (takeWhile, dropWhile)")
  val unpacked = 'a' :: 'a' :: 'a' :: 'b' :: 'c' :: 'c' :: 'a' :: Nil
  val packed = Pack.pack(unpacked)
  val encoded = Pack.encode(unpacked)
  println("unpacked " + unpacked)
  println("packed " + packed)
  println("encoded " + encoded)
  
}