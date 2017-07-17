

object MergeSort {
  def sort(xs:List[Int]):List[Int] = xs match {
    case Nil => xs
    case x :: Nil => xs
    case _ => {
      val (left, right) = xs.splitAt(xs.length / 2)
      merge(sort(left),sort(right))
    }
  }
  
  private def merge(left:List[Int], right:List[Int]):List[Int] = left match {
    case Nil => right
    case l :: l_remaining => right match {
      case Nil => left
      case r :: r_remaining =>
        if (l < r) l :: merge(l_remaining, right)
        else r :: merge(left, r_remaining)
    }
  }
}