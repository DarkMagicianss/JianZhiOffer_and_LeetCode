package LeetCode.数字.LRU缓存机制_____重写LinkedHashMap;


import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    //这是LinkedHashMap留的一个方法removeEldestEntry 覆盖其中的方法实现在什么情况下删除最后一个元素
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache1 = new LRUCache(2 /* 缓存容量 */);
        cache1.put(1, 1);
        cache1.put(2, 2);
        cache1.get(1);       // 返回  1
        cache1.put(3, 3);    // 该操作会使得密钥 2 作废
        cache1.get(2);       // 返回 -1 (未找到)
        cache1.put(4, 4);    // 该操作会使得密钥 1 作废
        cache1.get(1);       // 返回 -1 (未找到)
        cache1.get(3);       // 返回  3
        cache1.get(4);       // 返回  4
        LRUCache cache2 = new LRUCache(2 /* 缓存容量 */);
        cache2.put(2, 1);
        cache2.put(1, 1);
        cache2.put(2, 3);
        cache2.put(4, 1);
        cache2.get(1);
        cache2.get(2);
        LRUCache cache3 = new LRUCache(2 /* 缓存容量 */);
        cache3.get(2);
        cache3.put(2, 6);
        cache3.get(1);
        cache3.put(1, 5);
        cache3.put(1, 2);
        cache3.get(1);
        cache3.get(2);
    }
}

