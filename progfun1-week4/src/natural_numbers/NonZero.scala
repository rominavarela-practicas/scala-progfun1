package natural_numbers

class NonZero(_predecessor: Nat) extends Nat {
  def isZero = false
  
  def predecessor = _predecessor
  
  def successor = new NonZero(this)
  
  def + (that:Nat) = that match {
    case n: NonZero => this.successor + n.predecessor
    case _ => this
  }
  
  def - (that:Nat) = that match {
    case n: NonZero => this.predecessor - n.predecessor
    case z => this
  }
  
  def == (that:Nat) = that match {
    case n: NonZero => (this - that) == Zero
    case z => false
  }
}