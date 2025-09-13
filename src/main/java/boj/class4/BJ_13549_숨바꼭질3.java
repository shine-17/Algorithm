package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13549_숨바꼭질3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 1초 : -1, +1
            // 0초 : * 2
            System.out.println(find(n, k));

        } catch (Exception ignored) {}
    }

    static int find(int n, int k) {
        Integer[] dist = new Integer[100001];
        dist[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        PriorityQueue<Object> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (current == k) break;

            // *2, -1, +1 순서 중요
            // *2가 나중에 오게되면 -1,+1이 먼저 갱신하는 상황이 오게되어 최단 시간이 아닐 수도 있기 때문
            // 반례: 0 4. 답 1
            // 0 -> 1 (+1) -> 2 (0) -> 4 : 1
            // 0 -> 1 (+1) -> 2 (+1) -> 4 (*2) : 2
            if (current * 2 <= 100000 && dist[current * 2] == null) {
                dist[current * 2] = dist[current];
                queue.add(current * 2);
            }
            if (current - 1 >= 0 && dist[current - 1] == null) {
                dist[current - 1] = dist[current] + 1;
                queue.add(current - 1);
            }
            if (current + 1 <= 100000 && dist[current + 1] == null) {
                dist[current + 1] = dist[current] + 1;
                queue.add(current + 1);
            }
        }

        return dist[k];
    }
}
