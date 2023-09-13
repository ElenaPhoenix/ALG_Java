package ru.geekbrains.lesson4;

public class HashMap<K, V> {

    private static final int INIT_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.5; //50%
    private int size;

    private Bucket[] buckets;

    class Entity {
        K key;
        V value;
    }

    class Bucket<K, V> {

        Node head;

        class Node {
            Node next;

            Entity nodeValue;
        }

        public V add(Entity entity) {
            Node node = new Node();
            node.nodeValue = entity;

            if (head == null) {
                head = node;
                return null;
            }
            Node currentNode = head;
            while (true) {
                if (currentNode.nodeValue.key.equals(entity.key)) {
                    V buf = (V) currentNode.nodeValue.value;
                    currentNode.nodeValue.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = node;
                    return null;
                }
            }
        }

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.nodeValue.key.equals(key)) {
                    return (V) node.nodeValue.value;
                }
                node = node.next;
            }
            return null;
        }

        public V remove(K key) {
            if (head == null)
                return null;
            if (head.nodeValue.key.equals(key)) {
                V buf = (V) head.nodeValue.value;
                head = head.next;
                return buf;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.nodeValue.key.equals(key)) {
                        V buf = (V) node.next.nodeValue.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }


    }

    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void recalculate(){
        size = 0;
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++){
            Bucket<K, V> bucket = old[i];
            if (bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null){
                    put((K)node.nodeValue.key, (V)node.nodeValue.value);
                    node = node.next;
                }
            }
            old[i] = null;
        }
    }

    public V put(K key, V value) {

        if (buckets.length * LOAD_FACTOR <= size)
            recalculate();

        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        V ret = (V)bucket.add(entity);
        if (ret == null){
            size++;
        }
        return ret;
    }

    public V get(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V) bucket.get(key);
    }

    public V remove(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        V ret = (V) bucket.remove(key);
        if (ret != null){
            size--;
        }
        return ret;
    }

    public HashMap() {
        this(INIT_BUCKET_COUNT);
        //buckets = new Bucket[INIT_BUCKET_COUNT];
    }

    public HashMap(int initCount) {
        buckets = new Bucket[initCount];
    }


}
