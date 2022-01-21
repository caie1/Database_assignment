package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity, size;
    Map<Character, DoubleLinkedNode<Character, Integer>> cache = new HashMap<>();
    DoubleLinkedList lst = new DoubleLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(Character key) {
        DoubleLinkedNode<Character, Integer> node = cache.get(key);
        if (node == null) return -1;

        lst.removeNode(node);
        lst.addNode(node);
        return node.value;
    }

    public void set(Character key, Integer value) {
        DoubleLinkedNode<Character, Integer> node = cache.get(key);
        if (node ==  null){
            DoubleLinkedNode<Character, Integer> newNode = new DoubleLinkedNode<Character, Integer>();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            lst.addNode(newNode);
            size++;

            if (size > capacity){
                DoubleLinkedNode<Character, Integer> last = lst.removeLastNode();
                cache.remove(last.key);
                size--;
            }

        }else{
            node.value = value;
            lst.removeNode(node);
            lst.addNode(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache(2);
        lrucache.set('a',2);
        System.out.println("The size is:" + lrucache.size);
        lrucache.set('b',2);
        lrucache.set('a',3);
        int ans = lrucache.get('a');
        System.out.println("the value of key a is:"+ ans);
        System.out.println("The size is:" + lrucache.size);

    }

}
