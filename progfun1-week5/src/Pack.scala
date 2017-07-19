

object Pack {
  def pack[T](xs:List[T]): List[List[T]] = pack(xs, Nil)
  
  private def pack[T](xs:List[T], accum:List[List[T]]): List[List[T]] = xs match {
    case head :: tail => {
      val (slice, remaining) = xs.span( x => x == head )
      return pack(remaining, accum :+ slice)
    }
    case _ => accum
  }
  
  def encode[T](xs:List[T]): List[(T,Int)] = pack(xs, Nil).map( slice => (slice.head, slice.size))
}