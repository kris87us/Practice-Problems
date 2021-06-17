package datastructures;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyStack<E> {
    private int size = 0;
    private Object[] object;

    public MyStack(E[] object) {
        this.object = new Object[10];
    }

    public E pop() {
        E e = (E) object[--size];
        object[size] = null;
        return e;
    }

    public void push(E e) {
        if (size == object.length) {
           ensureCapacity();
        }
        object[size++] = e;
    }

    private void ensureCapacity() {
        if (size == object.length) {
            int newSize = object.length * 2;
            object = Arrays.copyOf(object, newSize);
        }
    }
}
