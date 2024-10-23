package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_11279_최대힙 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                int num = Integer.parseInt(br.readLine());
                queue.add(num);

                if(num == 0) {
                    System.out.println(queue.isEmpty() ? 0 : queue.poll());
                }
            }

        } catch(Exception ignored) {}
    }
}
