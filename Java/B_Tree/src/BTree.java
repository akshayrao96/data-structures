public class BTree<E extends Comparable<E>> implements BTreeInterface<E>{

  private final int LOAD_FACTOR = 4;
  private final int MIN_LOAD = LOAD_FACTOR / 2;
  private BTreeSegment<E> base;
  private int size;

  public BTree() {
    this.base = new BTreeSegment<E>(null, LOAD_FACTOR);
  }

  @Override
  public void add(E item) {

  }

  @Override
  public E remove(E item) {
    return null;
  }

  @Override
  public boolean contains(E item) {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }
}
