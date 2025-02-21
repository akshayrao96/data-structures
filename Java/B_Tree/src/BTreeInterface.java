public interface BTreeInterface<E> {

  public void add(E item);

  public E remove(E item);

  public boolean contains(E item);

  public int size();

}
