/**
 * Class is an implementation of ArrayListInterface, using Generics. It is supposed to mimic similarities in
 * the Java ArrayListInterface Data Structure.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayListImp<E> implements Iterable<E>, ArrayListInterface<E> {

  int CAPACITY = 10;
  private int size;
  private E[] array;


  /**
   * Constructs ArrayListImp, with size and an array of default capacity
   */
  public ArrayListImp() {
    this.size = 0;
    array = (E[]) new Object[CAPACITY];
  }

  /**
   * Adds element to end of the list
   * @param element - given element
   */
  public void add(E element) {
    if (size == array.length) {
      resizeUp();
    }
    array[size] = element;
    size++;
  }

  /**
   * Adds element at current index. Shifts elements over by 1
   * Resizes if larger array is needed
   * @param index - given index
   * @param element - given element
   */
  public void add(int index, E element) {
    if (index >= size) {
      throw new NoSuchElementException();
    }
    if (size == array.length) {
      resizeUp();
    }
    E prev = array[index];
    array[index] = element;
    for (int i = index + 1; i < size; i++) {
      E newPrev = array[i];
      array[i] = prev;
      prev = newPrev;
    }
    array[size] = prev;
    size++;
  }

  /**
   * Remove element if found in the list. Shifts elements back
   * Resizes down to conserve space
   * @param element - given element
   * @return element
   */
  public E remove(E element) {
    //TODO
    return null;
  }

  /**
   * Removes element at given index, if valid
   * @param index - given index
   * @return element
   */
  public E remove(int index) {
    if (index >= size) {
      throw new NoSuchElementException();
    }
    E elem = array[index];
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    array[size - 1] = null;
    size--;

    if (size / 4 < this.array.length) {
      resizeDown();
    }
    return elem;
  }

  /**
   * Gets number of elements that have been added
   * @return - size
   */
  public int size() {
    return size;
  }

  /**
   * Checks if no elements exist
   * @return - true if empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Gets an element from the given index
   * @param index - given index
   * @return element
   */
  public E get(int index) {
    return array[index];
  }

  /**
   * String representation of the data structure
   * @return - String
   */
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("[");
    for (int i = 0; i < size; i++) {
      result.append(array[i]).append(", ");
    }
    result.append("]");
    return result.toString();
  }

  /**
   * Iterator so that for each loop can be used
   * @return - Iterator object
   */
  public Iterator<E> iterator() {
    return new MyIterator<>();

  }

  /**
   * Resizes array up, by increasing space
   */
  private void resizeUp() {
    E[] newArray = (E[]) new Object[size * 2];
    if (size >= 0) {
      System.arraycopy(array, 0, newArray, 0, size);
    }
    array = newArray;
  }

  /**
   * Resizes array down, conserving space
   */
  private void resizeDown() {
    E[] newArray = (E[]) new Object[size / 2];
    if (size >= 0) {
      System.arraycopy(this.array, 0, newArray, 0, size);
    }
    this.array = newArray;
  }

  /**
   * Iterator class
   * @param <E> - Given type for data structure used
   */
  public class MyIterator<E> implements Iterator<E> {

    private int index;

    public MyIterator() {
      index = 0;
    }

    public boolean hasNext() {
      return index < size;
    }

    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E element = (E) array[index];
      index++;
      return element;
    }
  }
}