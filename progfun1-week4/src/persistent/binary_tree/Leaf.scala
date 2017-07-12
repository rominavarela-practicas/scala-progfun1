package presistent.binary_tree

import presistent.BinTreeNode

class Leaf[+V <: AnyVal](val value:V) extends BinTreeNode[V] {
  def root = toNumber(value)
  def left = EmptyLeaf
  def right = EmptyLeaf
  def isEmpty = false
  def hasChildren = false
  
  def contains [U >: V <: AnyVal] (other:U) = (value == other)
  
  private def toNumber (anyval:AnyVal) : Double = anyval match {
    case char:Char => char.asDigit
    case bool:Boolean => if (bool) 1 else 0
    case byte:Byte => byte.toDouble
    case short:Short => short.toDouble
    case int:Int => int.toDouble
    case long:Long => long.toDouble
    case float:Float => float.toDouble
    case double:Double => double
    case _ => 0
  }
  
  def > [U >: V <: AnyVal] (other:U) = root > toNumber(other)
  
  def < [U >: V <: AnyVal] (other:U) = root < toNumber(other)
  
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
  
  override def toString = value + "."
}