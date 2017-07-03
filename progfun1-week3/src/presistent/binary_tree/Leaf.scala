package presistent.binary_tree

import presistent.Node

class Leaf(val N:Int) extends Node[Int] {
  def rootValue = Some(N)
  def children = List()
  
  def contains(n:Int) = {
    N == n
  }
  
  def + (n:Int) = {
    if(n < N) new Branch(N, new Leaf(n), EmptyLeaf)
    else if(n > N) new Branch(N, EmptyLeaf, new Leaf(n))
    else this
  }
  
  
  def - (n:Int) = {
    if(N == n) EmptyLeaf
    else this
  }
  
  def u (other:Node[Int]) = {
    if(!other.rootValue.isDefined) this
    else if(other.contains(N)) other
    else if(other.rootValue.get < N) new Branch(N, other, EmptyLeaf)
    else new Branch(N, EmptyLeaf, other)
  }
  
  def n (other:Node[Int]) = {
    if(other.contains(N)) this
    else EmptyLeaf
  }
  
  override def toString = N + "."
}