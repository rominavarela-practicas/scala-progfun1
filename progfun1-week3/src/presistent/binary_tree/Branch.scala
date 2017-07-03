package presistent.binary_tree

import presistent.BinaryTree

class Branch (val N:Int, val left:BinaryTree[Int], val right:BinaryTree[Int]) extends BinaryTree[Int] {
  def rootValue = Some(N)
  
  def contains(n:Int) = {
    if(n < N) left.contains(n)
    else if(n > N) right.contains(n)
    else true
  }
  
  def > (n:Int) = {
    N > n
  }
  
  def < (n:Int) = {
    N < n
  }
  
  def + (n:Int) = {
    if(this.contains(n)) this
    else if(n < N) new Branch(N, left + n, right)
    else new Branch(N, left, right + n)
  }
  
  def + (n:Option[Int]) = {
    if(n.isDefined) this + n.get
    else this
  }
  
  def - (n:Int) = {
    if(!this.contains(n)) this
    else if(N == n) this.left u this.right
    else if(n < N) new Branch(N, left - n, right)
    else new Branch(N, left, right - n)
  }
  
  def u (other:BinaryTree[Int]) = {
    val $other = other - N
    
    if($other.rootValue.isEmpty) {
      this
    }
    else if(!$other.hasChildren) {
      if($other < N) new Branch(N, left + $other.rootValue, right)
      else new Branch(N, left, right + $other.rootValue)
    }
    else if($other < N) {
      if($other.right > N) new Branch(N, (left + $other.rootValue) u $other.left, right u $other.right)
      else new Branch(N, left u $other, right)
    }
    else {
      if($other.left < N) new Branch(N, left u $other.left, (right + $other.rootValue) u $other.right)
      else new Branch(N, left, right u $other)
    }
  }
  
  def n (other:BinaryTree[Int]) = {
    if(other.rootValue.isEmpty) {
      EmptyLeaf
    }
    else if(other.contains(N)) {
      val $other = other - N
      new Branch(N, left n $other, right n $other)
    }
    else {
      (left u right) n other
    }
  }
  
  override def toString = N + " {" + left + ", " + right + "}"
}