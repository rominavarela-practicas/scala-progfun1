package presistent.binary_tree

import presistent.BinTreeNode

class Branch[+V <: AnyVal](val value:V, val left:BinTreeNode[V], val right:BinTreeNode[V]) extends BinTreeNode[V] {
  def isEmpty = false
  def hasChildren = true
  
  def contains [U >: V <: AnyVal] (other:U) = {
    if(this > other)  left.contains(other)
    else if(this < other) right.contains(other)
    else true
  }
  
  def > [U >: V <: AnyVal] (other:U) = (new Leaf(value) > other)
  
  def < [U >: V <: AnyVal] (other:U) = (new Leaf(value) < other)
  
  def > [U >: V <: AnyVal] (node:BinTreeNode[U]) = node match {
    case branch:Branch[U] => this > branch.value
    case leaf:Leaf[U] => this > leaf.value
    case _ => false
  }
  
  def < [U >: V <: AnyVal] (node:BinTreeNode[U]) = node match {
    case branch:Branch[U] => this < branch.value
    case leaf:Leaf[U] => this < leaf.value
    case _ => false
  }
  
  def + [U >: V <: AnyVal] (other:U) = {
    if(this contains other) this
    if(this > other) new Branch(value, left + other, right)
    else new Branch(value, left, right + other)
  }
  
  override def toString = value + " {" + left + ", " + right + "}"
}