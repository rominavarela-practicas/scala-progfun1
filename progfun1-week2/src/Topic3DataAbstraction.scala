

object Topic3DataAbstraction {
  class Rational(num:Int, denom:Int) {
    require(denom!=0, "denominator must be non-zero") //also assert(denom!=0)
    
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
    
    def add(that:Rational) = {
      new Rational(
          this.numerator * that.denominator + that.numerator * this.denominator,
          this.denominator * that.denominator
      )
    }
    
    def substract(that:Rational) = add(that.neg)
    
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
    println("Topic 3")
    println("Data Abstraction")
    println("From the inside, data structures are sets of values. A class is a kind of data structure with contructor and methods.")
    
    val rational1 = new Rational(10,3)
    val rational2 = new Rational(8,12)
    
    println(s"${rational1} + ${rational2} = ${rational1.add(rational2)}")
    println(s"${rational1} - ${rational2} = ${rational1.substract(rational2)}")
    
    try {
      println("... trying to create 1/0")
      new Rational(1,0)
    } catch {
      case e:Exception => println(s"Exception: ${e.getMessage}")
    }
  }
}