import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
    }

    public MyList(int capacity) {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        Object[] newArr = new Object[elements.length + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = elements[i];
        }
        newArr[index] = element;
        for (int i = index; i < newArr.length; i++) {
            newArr[i + 1] = elements[i];
        }
    }

    public E remove(int index) {
        Object[] newArr = new Object[elements.length - 1];
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        E removed = (E) elements[index];
        for (int i = 0, j = 0; i < elements.length; i++) {
            if (i != index) {
                newArr[j++] = elements[i];
            }
        }
        newArr = elements;
        return removed;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            count++;
        }
        return count;
    }

    public E clone() {
        Object[] newArr = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        return (E) newArr;
    }

    public boolean contains(E o) {
        if (o == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(E e) {
        Object[] newArr = new Object[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        elements = new Object[minCapacity];
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
