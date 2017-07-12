package natural_numbers

trait Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that:Nat): Nat
  def - (that:Nat): Nat
  def == (that:Nat): Boolean
}