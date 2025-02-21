public class TreeNode<E> {

  private E value;
  private TreeNode<E> left;
  private TreeNode<E> right;
  private TreeNode<E> reference;

  public TreeNode(E value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.reference = null;
  }

  public E getValue() {
    return value;
  }

  public TreeNode<E> getLeft() {
    return left;
  }

  public TreeNode<E> getRight() {
    return right;
  }

  public TreeNode<E> getReference() {
    return reference;
  }

  public void setValue(E value) {
    this.value = value;
  }

  public void setLeft(TreeNode<E> left) {
    this.left = left;
  }

  public void setRight(TreeNode<E> right) {
    this.right = right;
  }

  public void setReference(TreeNode<E> reference) {
    this.reference = reference;
  }
}
