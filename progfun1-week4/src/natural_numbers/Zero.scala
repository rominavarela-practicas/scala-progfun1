package natural_numbers

object Zero extends Nat {
  def isZero = true
  
  def predecessor = throw new Error("Zero.predecessor")
  
  def successor = new NonZero(this)
  
  def + (that:Nat) = that
  
  def - (that:Nat) = that match {
    case n: NonZero => throw new Error("Zero.predecessor")
    case z => this
  }
  
  def == (that:Nat) = that match {
    case n: NonZero => false
    case z => true
  }
}