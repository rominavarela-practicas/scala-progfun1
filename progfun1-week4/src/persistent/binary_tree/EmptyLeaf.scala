package presistent.binary_tree

import presistent.BinTreeNode

object EmptyLeaf extends BinTreeNode[Nothing] {
  def left = this
  def right = this
  def isEmpty = true
  def hasChildren = false
  
  def contains [U <: AnyVal] (elem:U) = false
  def > [U <: AnyVal] (other:U) = false
  def < [U <: AnyVal] (other:U) = false
  def > [U <: AnyVal] (node:BinTreeNode[U]) = false
  def < [U <: AnyVal] (node:BinTreeNode[U]) = false
  
  def + [U <: AnyVal] (other:U) = new Leaf(other)
  
  override def toString = "_."
}