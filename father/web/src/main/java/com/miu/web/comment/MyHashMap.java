package com.miu.web.comment;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements MyMap<K, V> {

    //数组默认初始化长度   16
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    //默认阀值
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;

    private float defaultLoadFactor;

    //map当中entry数量
    private int entryUserSize;

    //数组
    private com.miu.web.comment.Entry<K, V>[] table = null;

    public MyHashMap() throws Exception {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) throws Exception {
        if (defaultInitialCapacity < 0) {
            throw new IllegalAccessException("defaultInitialCapacity:" + defaultInitialCapacity);
        }

        if (defaultLoadFactor <= 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalAccessException("defaultLoadFactor:" + defaultLoadFactor);
        }

        this.defaultInitSize = defaultInitialCapacity;
        this.defaultLoadFactor = defaultLoadFactor;
        table = new com.miu.web.comment.Entry[this.defaultInitSize];
    }

    @Override
    public V put(K k, V v) {
        V oldValue = null;
        //是否需要扩容
        //扩容完毕，肯定需要重新装载
        if (entryUserSize >= defaultInitSize * defaultLoadFactor) {
            resize(2 * defaultInitSize);
        }

        //得到hash值，计算出数组中的位子
        int index = hash(k) & (defaultInitSize - 1);
        if(table[index] == null){
            table[index] = new com.miu.web.comment.Entry<>(k,v,null);
            ++entryUserSize;
        }else {
            //需要遍历单列表
            com.miu.web.comment.Entry<K,V> entry = table[index];
            while(entry != null){
                if(k == entry.getKey() || k.equals(entry.getKey())){
                    oldValue = entry.getValue();
              /*      entry.value = v;*/
                    return oldValue;
                }
            }
            table[index] = new com.miu.web.comment.Entry<>(k,v,entry);
            ++entryUserSize;
        }
        return oldValue;
    }

    private int hash(K k) {
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 14);
    }

    private void resize(int i) {
        com.miu.web.comment.Entry[] newTable = new com.miu.web.comment.Entry[i];
        //改变数组大小
        defaultInitSize = i;
        entryUserSize = 0;
        rehash(newTable);
    }

    private void rehash(com.miu.web.comment.Entry[] newTable) {
        //循环老的Entry集合，注意遍历单链表
        List<Entry<K, V>> entryList = new ArrayList<Entry<K, V>>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    entryList.add(entry);
                    //entry = entry.next;
                } while (entry != null);
            }
        }

        //覆盖旧的引用
        if (newTable.length > 0) {
            table = newTable;
        }

        //所谓重新hash，就是重新put  entry 到hashmap
        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize - 1);
        if(table[index] == null){
            return null;
        }else{
            Entry<K,V> entry = table[index];
            do{
                if(k == entry.getKey() || k.equals(entry.getKey())){
                    return entry.getValue();
                }
            }while(entry != null);
        }
        return null;
    }
}
