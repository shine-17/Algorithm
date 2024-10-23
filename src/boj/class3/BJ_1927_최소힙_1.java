package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927_최소힙_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                int num = Integer.parseInt(br.readLine());

                if(num == 0) {
                    System.out.println(queue.isEmpty() ? 0 : queue.poll());
                    continue;
                }

                queue.add(num);
            }

        } catch(Exception ignored) {}
    }
}