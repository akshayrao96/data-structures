public class BTreeSegment<E extends Comparable<E>> {

  private TreeNode<E> root;
  private TreeNode<E> ghost;
  private int size;
  private int maxSize;

  public BTreeSegment(E value, int capacity) {
    this.size = 0;
    this.maxSize = capacity;
    this.root = new TreeNode<>(value);
    this.ghost = new TreeNode<>(null);
  }

  public void add(E value) {
    TreeNode<E> current = this.root;
    add(current, value);
    this.size += 1;
  }

  private void add(TreeNode<E> current, E value) {
    if (value.compareTo(current.getValue()) < 0) {
      if (current.getLeft() == null) {
        current.setLeft(new TreeNode<>(value));
      } else {
        add(current.getLeft(), value);
      }
    } else {
      if (current.getRight() == null) {
        current.setRight(new TreeNode<>(value));
      } else {
        add(current.getRight(), value);
      }
    }
  }

  private boolean contains(E value) {
    TreeNode<E> current = this.root;
    return contains(current, value);
  }

  private boolean contains(TreeNode<E> current, E value) {
    if (current == null) return false;
    if (current.getValue().equals(value)) return true;
    return contains(current.getLeft(), value) || contains(current.getRight(), value);
  }

  /**
   * Gets the floor node of the tree. This is to get references for the next
   * B Tree segment. If floor is invalid (lowest value), then we return the ghost
   * node reference
   * @return - Node closest to given value, but must be less than.
   */
  private E floor(E value) {
    //TODO
    return null;
  }
}
