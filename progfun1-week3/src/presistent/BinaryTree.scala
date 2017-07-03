package presistent

trait BinaryTree[T <: AnyVal] {
  def rootValue : Option[T]
  def left : BinaryTree[T]
  def right : BinaryTree[T]
  def hasChildren : Boolean = left.rootValue.isDefined && right.rootValue.isDefined
  
  def contains(elem:T) : Boolean
  def > (elem:T) : Boolean
  def < (elem:T) : Boolean
  def + (elem:T) : BinaryTree[T]
  def + (elem:Option[T]) : BinaryTree[T]
  def - (elem:T) : BinaryTree[T]
  def u (other:BinaryTree[T]) : BinaryTree[T]
  def n (other:BinaryTree[T]) : BinaryTree[T]
}