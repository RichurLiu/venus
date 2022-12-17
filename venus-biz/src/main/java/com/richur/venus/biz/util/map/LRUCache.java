package com.richur.venus.biz.util.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache(int capacity){
        super(capacity, 1.0F, true);
        this.capacity = capacity;
    }

    public V get(Object key) {
        return super.getOrDefault(key, null);
    }

    public V put(K key, V value) {
        return super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.capacity;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache<String, Integer>(3);

        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        lru.put("4", 4);

        System.out.println(lru.get("1"));

        for (Object o : lru.entrySet()) {
            System.out.print(o +",");
        }

        System.out.println(lru.get("2"));
        for (Object o : lru.entrySet()) {
            System.out.print(o +",");
        }
        System.out.println(lru.get("4"));
        for (Object o : lru.entrySet()) {
            System.out.print(o +",");
        }
        System.out.println(lru.put("5", 5));
        for (Object o : lru.entrySet()) {
            System.out.print(o +",");
        }



    }
}
