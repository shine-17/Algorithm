package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3_1 {
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
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(start, 0));

        int[] dist = new int[INF];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.value == end) break;

            if (point.value * 2 < INF && dist[point.value*2] > point.time) {
                dist[point.value*2] = point.time;
                queue.add(new Point(point.value*2, point.time));
            }
            if (point.value + 1 < INF && dist[point.value+1] > point.time+1) {
                dist[point.value+1] = point.time+1;
                queue.add(new Point(point.value+1, point.time+1));
            }
            if (point.value - 1 >= 0 && dist[point.value-1] > point.time+1) {
                dist[point.value-1] = point.time+1;
                queue.add(new Point(point.value-1, point.time+1));
            }
        }

        return dist[end];
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
