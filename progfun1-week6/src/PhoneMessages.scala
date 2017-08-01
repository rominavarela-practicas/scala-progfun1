

object PhoneMessages {
  val nmemonics = Map(
      '2' -> "ABC",
      '3' -> "DEF",
      '4' -> "GHI",
      '5' -> "JKL",
      '6' -> "MNO",
      '7' -> "PQRS",
      '8' -> "TUV",
      '9' -> "WXYZ"
  );
  
  def translate(numSeq:Iterable[Char]):String = translate(numSeq, "")
  
  private def translate(numSeq:Iterable[Char], accum:String):String = numSeq match {
    case Nil => return accum
    case nmemonic :: _ => {
      val (ocurrences, pending) = numSeq.span( n => n == nmemonic)
      return translate(pending, accum + mapNmemonic(nmemonic, ocurrences.size))
    }
  }
  
  private def mapNmemonic(nmemonic:Char, occurences:Int):String = {
    val mapper = nmemonics(nmemonic)
    
    val overflows = {
      val n = (occurences/mapper.size).toInt
      (0 until n).map { _ => mapper.last }
    }
    
    val last = {
      val i = occurences - (overflows.size * mapper.size)
      if(i > 0)
        mapper.charAt(i - 1)
      else
        '\0'
    }
    
    return (overflows :+ last).mkString;
  }
}