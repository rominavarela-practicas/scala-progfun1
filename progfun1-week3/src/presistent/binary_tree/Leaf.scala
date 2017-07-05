package presistent.binary_tree

import presistent.BinTreeNode

class Leaf(val N:Int) extends BinTreeNode[Int] {
  def rootValue = Some(N)
  def left = EmptyLeaf
  def right = EmptyLeaf
  
  def contains(n:Int) = {
    N == n
  }
  
  def > (n:Int) = {
    N > n
  }
  
  def < (n:Int) = {
    N < n
  }
  
  def + (n:Int) = {
    if(n < N) new Branch(N, new Leaf(n), EmptyLeaf)
    else if(n > N) new Branch(N, EmptyLeaf, new Leaf(n))
    else this
  }
  
  def + (n:Option[Int]) = {
    if(n.isDefined) this + n.get
    else this
  }
  
  def - (n:Int) = {
    if(N == n) EmptyLeaf
    else this
  }
  
  def u (other:BinTreeNode[Int]) = {
    if(other.isEmpty) this
    else if(other.contains(N)) other
    else if(other.rootValue.get < N) new Branch(N, other, EmptyLeaf)
    else new Branch(N, EmptyLeaf, other)
  }
  
  def n (other:BinTreeNode[Int]) = {
    if(other.contains(N)) this
    else EmptyLeaf
  }
  
  override def toString = N + "."
}