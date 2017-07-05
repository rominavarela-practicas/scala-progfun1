package presistent

trait BinTreeNode[T <: AnyVal] {
  def rootValue : Option[T]
  def left : BinTreeNode[T]
  def right : BinTreeNode[T]
  def isEmpty : Boolean = rootValue.isEmpty
  def hasChildren : Boolean = left.rootValue.isDefined || right.rootValue.isDefined
  
  def contains(elem:T) : Boolean
  def > (elem:T) : Boolean
  def < (elem:T) : Boolean
  def + (elem:T) : BinTreeNode[T]
  def + (elem:Option[T]) : BinTreeNode[T]
  def - (elem:T) : BinTreeNode[T]
  def u (other:BinTreeNode[T]) : BinTreeNode[T]
  def n (other:BinTreeNode[T]) : BinTreeNode[T]
}