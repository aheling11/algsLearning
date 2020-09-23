package leetcode;

import java.util.HashMap;

class LRUCache  {
    int count;
    int capacity;
    LinkedNode head;
    LinkedNode tail;

    HashMap<Integer, LinkedNode> cache = new HashMap<>();

    class LinkedNode{
        int key;
        int value;
        LinkedNode next;
        LinkedNode prev;
    }


    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;

        head = new LinkedNode();
        head.prev = null;

        tail = new LinkedNode();
        tail.next = null;

        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);

        if(node == null){
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            this.count++;

            addNode(newNode);
            if (count > capacity){
                LinkedNode tailNode = popTail();
                this.count--;
                cache.remove(tailNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(LinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private LinkedNode popTail(){
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(LinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node){
        node.prev.next =  node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */