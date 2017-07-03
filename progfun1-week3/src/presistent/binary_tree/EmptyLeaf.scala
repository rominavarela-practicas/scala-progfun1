package presistent.binary_tree

import presistent.Node

/**
 * In scala, an object is a singleton.
 * All empty leafs point to the same construct.
 */
object EmptyLeaf extends Node[Int] {
  def rootValue = None
  def children = List()
  
  def contains(n:Int) = false
  def + (n:Int) = new Leaf(n)
  def - (n:Int) = this
  def u (other:Node[Int]) = other
  def n (other:Node[Int]) = this
  
  override def toString = "_."
}