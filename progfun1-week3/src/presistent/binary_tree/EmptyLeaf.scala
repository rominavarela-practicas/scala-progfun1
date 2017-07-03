package presistent.binary_tree

import presistent.BinaryTree

object EmptyLeaf extends BinaryTree[Int] {
  def rootValue = None
  def left = this
  def right = this
  
  def contains(n:Int) = false
  def > (n:Int) = false
  def < (n:Int) = false
  def + (n:Int) = new Leaf(n)
  def + (n:Option[Int]) = if(n.isDefined) new Leaf(n.get) else this
  def - (n:Int) = this
  def u (other:BinaryTree[Int]) = other
  def n (other:BinaryTree[Int]) = this
  
  override def toString = "_."
}