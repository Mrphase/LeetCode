package AmazonOA2;

import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
The cache is initialized with a positive capacity.
Follow up:
Could you do both operations in O(1) time complexity?
Example:
 */
public class L146_LRU_cache {
    public class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            /**
             * Always add the new node right after head.
             */
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node){
            /**
             * Remove an existing node from the linked list.
             */
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node){
            /**
             * Move certain node in between to the head.
             */
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            /**
             * Pop the current tail.
             */
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            // head.prev = null;

            tail = new DLinkedNode();
            // tail.next = null;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;

            // move the accessed node to the head;
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                ++size;

                if(size > capacity) {
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // update the value.
                node.value = value;
                moveToHead(node);
            }
        }
    }

}
