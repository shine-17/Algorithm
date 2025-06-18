package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3_2 {
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
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        int[] dist = new int[INF];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Integer point = queue.poll();

            if (point == end) break;

            if (point * 2 < INF && dist[point*2] == INF) {
                dist[point*2] = dist[point];
                queue.add(point*2);
            }
            if (point - 1 >= 0 && dist[point-1] == INF) {
                dist[point-1] = dist[point]+1;
                queue.add(point-1);
            }
            if (point + 1 < INF && dist[point+1] == INF) {
                dist[point+1] = dist[point]+1;
                queue.add(point+1);
            }
        }

        return dist[end];
    }
}
