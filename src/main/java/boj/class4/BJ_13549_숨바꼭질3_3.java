package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13549_숨바꼭질3_3 {
    static final int INF = 100001;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());


            int time = find(n, k);
            System.out.println(time);

        } catch (Exception ignored) {}
    }

    static int find(int start, int end) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        queue.add(new Point(start, 0));

        boolean[] visited = new boolean[INF];

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.value == end) return point.time;

            visited[point.value] = true;

            if (point.value * 2 < INF && !visited[point.value * 2]) {
                queue.add(new Point(point.value*2, point.time));
            }
            if (point.value + 1 < INF && !visited[point.value + 1]) {
                queue.add(new Point(point.value+1, point.time+1));
            }
            if (point.value - 1 >= 0 && !visited[point.value - 1]) {
                queue.add(new Point(point.value-1, point.time+1));
            }
        }

        return 0;
    }

    static class Point {
        int value;
        int time;

        public Point(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
}
