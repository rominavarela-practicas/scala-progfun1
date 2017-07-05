package presistent

import presistent.binary_tree.EmptyLeaf

object BinaryTree {
  def apply(elems: Int*):BinTreeNode[Int] = {
    var tree:BinTreeNode[Int] = EmptyLeaf
    elems.foreach { e =>
      tree = tree + e
    }
    return tree
  }
}