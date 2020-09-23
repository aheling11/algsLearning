package leetcode;

import java.util.*;


public class LRU {


    class LinkedNode {
        int key;
        int value;
        LinkedNode next;
        LinkedNode prev;
    }

    int capacity;
    int size;
    LinkedNode head;
    LinkedNode tail;

    HashMap<Integer, LinkedNode> cache = new HashMap<>();

    public int[] LRU(int[][] operators, int k) {
        capacity = k;

        head = new LinkedNode();
        tail = new LinkedNode();

        head.prev = null;
        tail.next = null;

        head.next = tail;
        tail.prev = head;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1){
                set(operators[i][1], operators[i][2]);
            } else if (operators[i][0] == 2){
                list.add(get(operators[i][1]));
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null){
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;

            addNode(newNode);

            cache.put(key, newNode);
            size++;
            if(size > capacity){
                LinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
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

    public LinkedNode popTail(){
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;

    }

    public void addNode(LinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}