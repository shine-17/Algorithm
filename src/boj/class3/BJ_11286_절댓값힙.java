package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {

            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
                int diff = Math.abs(o1) - Math.abs(o2);
                if(diff == 0) return o1 - o2;

                return diff;
            });

            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                int x = Integer.parseInt(br.readLine());

                if(x != 0) {
                    queue.add(x);
                }
                else {
                    int num = queue.isEmpty() ? 0 : queue.poll();
                    sb.append(num).append("\n");
                }
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }
}
