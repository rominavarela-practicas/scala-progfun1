package presistent.binary_tree

import presistent.Node

class Branch (val N:Int, val left:Node[Int], val right:Node[Int]) extends Node[Int] {
  def rootValue = Some(N)
  def children = left :: right :: Nil
  
  def contains(n:Int) = {
    if(n < N) left.contains(n)
    else if(n > N) right.contains(n)
    else true
  }
  
  def + (n:Int) = {
    if(this.contains(n)) this
    else if(n < N) new Branch(N, left + n, right)
    else new Branch(N, left, right + n)
  }
  
  def - (n:Int) = {
    if(!this.contains(n)) this
    else if(N == n) this.left u this.right
    else if(n < N) new Branch(N, left - n, right)
    else new Branch(N, left, right - n)
  }
  
  def u (other:Node[Int]) = {
    val $other = other - N
    
    if($other.rootValue.isEmpty) {
      this
    } else {
      val $val = $other.rootValue.get
      
      if($other.children.isEmpty) {
        if($val < N) new Branch(N, left + $val, right)
        else new Branch(N, left, right + $val)
      }
      else {
        val $left = $other.children.head
        val $right = $other.children.last
        
        if($val < N) {
          if($right.rootValue.getOrElse(N-1) > N) new Branch(N, (left + $val) u $left, right u $right)
          else new Branch(N, left u $other, right)
        }
        else {
          if($left.rootValue.getOrElse(N+1) < N) new Branch(N, left u $left, (right + $val) u $right)
          else new Branch(N, left, right u $other)
        }
      }
    }
    
  }
  
  def n (other:Node[Int]) = {
    if(other.rootValue.isEmpty) EmptyLeaf
    else if(other.contains(N)) {
      val $other = other - N
      new Branch(N, left n $other, right n $other)
    }
    else (left u right) n other
  }
  
  override def toString = N + " {" + left + ", " + right + "}"
}