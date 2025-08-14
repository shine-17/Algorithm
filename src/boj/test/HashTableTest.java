package boj.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashTableTest {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);

        Thread thread1 = new Thread(() -> {
            System.out.println(concurrentHashMap.get(1));
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(concurrentHashMap.get(1));
        });
        Thread thread3 = new Thread(() -> {
            concurrentHashMap.put(1, 2);
        });
        Thread thread4 = new Thread(() -> {
            System.out.println(concurrentHashMap.get(1));
        });
    }

    static class Node {
        int id;

        AtomicInteger status = new AtomicInteger(1);

        public void setStatus(int expected, int update) {
            status.compareAndSet(expected, update);
        }

        public Node(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
