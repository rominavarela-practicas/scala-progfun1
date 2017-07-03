package presistent

trait Node[T] {
  def rootValue : Option[T]
  def children : List[Node[Int]]
  
  def contains(elem:T) : Boolean
  def + (elem:T) : Node[T]
  def - (elem:T) : Node[T]
  def u (other:Node[T]) : Node[T]
  def n (other:Node[T]) : Node[T]
}