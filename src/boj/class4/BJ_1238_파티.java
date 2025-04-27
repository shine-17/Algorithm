package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1238_파티 {
    static ArrayList<Route>[] village;
    static final int MAX_TIME = 100 * 10000 + 1;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            village = new ArrayList[n + 1];

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (village[start] == null) village[start] = new ArrayList<>();

                village[start].add(new Route(end, t));
            }

            int time = Integer.MIN_VALUE;
            for (int i=1; i<=n; i++) {
                if (i == x) continue;

                time = Math.max(time, attendParty(i, x) + attendParty(x, i));
            }

            System.out.println(time);

        } catch (Exception ignored) {}
    }

    static int attendParty(int start, int end) {
        PriorityQueue<Route> queue = new PriorityQueue<>(village[start]);
        int[] dist = new int[1001];
        Arrays.fill(dist, MAX_TIME);

        for (Route route : village[start]) {
            dist[route.end] = route.time;
        }

        while (!queue.isEmpty()) {
            Route route = queue.poll();

            for (Route nextRoute : village[route.end]) {
                if (dist[nextRoute.end] > dist[route.end] + nextRoute.time) {
                    dist[nextRoute.end] = dist[route.end] + nextRoute.time;
                    queue.add(nextRoute);
                }
            }
        }

        return dist[end];
    }

    static class Route implements Comparable<Route> {
        int end;
        int time;

        public Route(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Route o) {
            return this.time - o.time;
        }
    }
}
