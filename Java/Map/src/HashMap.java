import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashMap<K, V> {

  private static final int INIT_CAPACITY = 10;
  private LinkedList<Pair<K, V>>[] arr;
  private int size;

  public HashMap() {
    this.arr = new LinkedList[INIT_CAPACITY];
    this.size = 0;
  }

  public void put(K key, V val) {
    int getIdx = hashFunction(key);
    Pair<K, V> item = getEntry(key);
    if (item == null) {
      if (arr[getIdx] == null) {
        arr[getIdx] = new LinkedList<>();
      }
      arr[getIdx].addFirst(new Pair<>(key, val));
      this.size += 1;
    } else {
      item.setVal(val);
    }
  }

  public V get(K key) {
    Pair<K, V> item = getEntry(key);
    if (item == null) {
      throw new NoSuchElementException("No Such entry with given key found");
    }
    return item.getVal();
  }

  public Pair<K, V> removeEntry(K key) {
    Pair<K, V> item = getEntry(key);
    if (item == null) {
      throw new NoSuchElementException("No such entry with given key found");
    }
    int getIdx = hashFunction(key);
    this.arr[getIdx].removeIf(curr -> curr.getKey().equals(key));
    this.size -= 1;
    return item;
  }

  private Pair<K, V> getEntry(K key) {
    int getIdx = hashFunction(key);
    if (this.arr[getIdx] == null) {
      return null;
    }

    for (Pair<K, V> item : arr[getIdx]) {
      if (item.getKey().equals(key)) {
        return item;
      }
    }
    return null;
  }

  private int hashFunction(K key) {
    int hashCode = Math.abs(key.hashCode());
    int idx = hashCode % this.arr.length;
    return idx;
  }

  private int loadFactor() {
    return this.size / this.arr.length;
  }

  public int size() {
    return this.size;
  }
}


/*
HashMap:

Contains array entry of LinkedList
LinkedList of Pair items (key, value)
Key can be anything, K
Value can be anything, V
Hash function

Make a Pair class of generics DONE
size = done

default size = 10

*/