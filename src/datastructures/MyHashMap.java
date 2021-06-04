package datastructures;

import java.util.LinkedList;

class MyHashMap {
    LinkedList<Entry>[] buckets;
    static int SIZE = 769;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = buckets[bucket];
        if (entries == null) {
            entries = new LinkedList<Entry>();
        } else {
            for (Entry entry: entries) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
        }
        entries.add(new Entry(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = buckets[bucket];
        if (entries == null) return -1;
        else {
            for (Entry entry : entries) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = buckets[bucket];
        if (entries == null) return;
        else {
            for (Entry entry : entries) {
                if (entry.key == key) {
                    entries.remove(key);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
    }
}

class Entry {
    public int key;
    public int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


