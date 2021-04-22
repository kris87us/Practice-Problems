package datastructures;

import java.util.Arrays;

class KeyValue<K, V> {
    private final K key;
    private V value;

    KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class MyMap<K, V> {
    private int size;
    private KeyValue<K, V>[] object;

    public MyMap(KeyValue<K, V>[] object) {
        this.object = new KeyValue[16];
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (object[i].getKey().equals(key)) {
                return object[i].getValue();
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean inserted = false;
        for (int i = 0; i < size; i++) {
            if (object[i].getKey().equals(key)) {
                object[i].setValue(value);
                inserted = true;
            }
        }
        if (!inserted) {
            object[size++] = new KeyValue<>(key, value);
        }
    }

    private void ensureCapacity() {
        if (size == object.length) {
            int newSize = object.length * 2;
            object = Arrays.copyOf(object, newSize);
        }
    }
}
