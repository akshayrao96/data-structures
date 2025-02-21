public class BTreeRootNode<E> {
  private E[] values;
  private BTreeSegment[] references;
  public BTreeRootNode(int capacity) {
    this.values = (E[]) new Object[capacity];
    this.references = (BTreeSegment[]) new Object[capacity + 1];
  }
}
