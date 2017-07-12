package presistent

import presistent.binary_tree.EmptyLeaf

trait BinTreeNode[+V <: AnyVal] {
  def left : BinTreeNode[V]
  def right : BinTreeNode[V]
  def isEmpty : Boolean
  def hasChildren : Boolean
  
  def contains [U >: V <: AnyVal] (other:U) : Boolean
  def > [U >: V <: AnyVal] (other:U) : Boolean
  def < [U >: V <: AnyVal] (other:U) : Boolean
  def > [U >: V <: AnyVal] (node:BinTreeNode[U]) : Boolean
  def < [U >: V <: AnyVal] (node:BinTreeNode[U]) : Boolean
  
  def :: [U >: V <: AnyVal] (other:U) : BinTreeNode[U]
}