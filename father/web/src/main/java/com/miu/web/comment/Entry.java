package com.miu.web.comment;

public class Entry<K, V> implements MyMap.Entry<K, V> {

    private K key;

    private V value;

    private Entry<K, V> next;

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public Entry(){

    }

    public Entry(K key,V value,Entry<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }


    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
