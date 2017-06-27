

object Topic4InfixNotationAndRelaxedIdentifiers {
  class Rational(num:Int, denom:Int) {
    require(denom!=0, "denominator must be non-zero")
    
    // normalize values as soon as possible to avoid arithmetic overflows
    val g = gcd(num,denom)
    val numerator = num/g
    val denominator = denom/g
    
    private def gcd(a:Int, b:Int):Int = {
       if(b==0) a
       else gcd(b, a % b)
    }
    
    def neg = {
      new Rational( - numerator, denominator )
    }
    
    def + (that:Rational) = {
      new Rational(
          this.numerator * that.denominator + that.numerator * this.denominator,
          this.denominator * that.denominator
      )
    }
    
    def - (that:Rational) = this + that.neg
    
    override def toString:String = {
      val integer = Math.floor(numerator/denominator).intValue()
      val reduced_numerator = numerator - (integer * denominator)
      if(integer > 0) {
        if(reduced_numerator == 0) return s"${integer}"
        else return s"${integer} (${reduced_numerator}/${denominator})"
      }
      else
        return s"${numerator}/${denominator}"
    }
  }
  
  def apply() {
    println("Topic 4")
    println("Infix Notation and Relaxed Identifiers")
    println("- Any method with a parameter can be used like an infix operator.")
    println("- Identifiers can be symbolic.")
    
    val rational1 = new Rational(10,3)
    val rational2 = new Rational(8,12)
    
    println(s"${rational1} + ${rational2} = ${rational1 + rational2}")
    println(s"${rational1} - ${rational2} = ${rational1 - rational2}")
    
  }
}