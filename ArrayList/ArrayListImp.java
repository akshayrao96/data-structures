import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayListImp<E> implements Iterable<E> {

    private int size;
    private E[] array;
    int CAPACITY = 10;


    public ArrayListImp() {
        this.size = 0;
        array = (E[]) new Object[CAPACITY];
    }

    public void add(E element) {
        if (size == array.length) {
            resize();
        }
        array[size] = element;
        size++;
    }

    public void add(int index, E element) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
        if (size == array.length) {
            resize();
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
        return elem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return array[index];
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i] + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result + "]";
    }

    public Iterator<E> iterator() {
        return new MyIterator<>();

    }

    private void resize() {
        E[] newArray = (E[]) new Object[size * 2];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }


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

class Main {
    public static void main(String[] args) {
        ArrayListImp<String> list = new ArrayListImp<>();
        list.add("hello");
        list.add("mister");
        list.add("chocolate");
        list.add("vehicle");
        for (String item : list) {
            System.out.println(item);
        }
    }
}

