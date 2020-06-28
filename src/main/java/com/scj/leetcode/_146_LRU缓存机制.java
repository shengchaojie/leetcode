package com.scj.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author shengchaojie
 * @date 2020/6/27
 **/
public class _146_LRU缓存机制 {

    class LRUCache {

        private Map<Integer,Integer> cache ;

        public LRUCache(int capacity) {
            cache = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return this.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            cache.put(key,value);
        }
    }


}
