package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1865_웜홀 {
    static ArrayList<Route>[] worlds;
    static final int INF = 2500 * 10000; // 25,000,000

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int tc = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();

            for (int i=0; i<tc; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()); // 지점 수
                int m = Integer.parseInt(st.nextToken()); // 도로 개수
                int w = Integer.parseInt(st.nextToken()); // 웜홀 개수

                worlds = new ArrayList[n+1];

                // 도로 (방향 없음)
                for (int j=0; j<m; j++) {
                    st = new StringTokenizer(br.readLine());

                    int s = Integer.parseInt(st.nextToken()); // 연결 지점 번호
                    int e = Integer.parseInt(st.nextToken()); // 연결 지점 번호
                    int t = Integer.parseInt(st.nextToken()); // 걸리는 시간

                    if (worlds[s] == null) worlds[s] = new ArrayList<>();
                    if (worlds[e] == null) worlds[e] = new ArrayList<>();

                    worlds[s].add(new Route(e, t));
                    worlds[e].add(new Route(s, t));
                }

                // 웜홀 (방향 있음)
                for (int j=0; j<w; j++) {
                    st = new StringTokenizer(br.readLine());

                    int s = Integer.parseInt(st.nextToken()); // 시작 지점
                    int e = Integer.parseInt(st.nextToken()); // 도착 지점
                    int t = Integer.parseInt(st.nextToken()); // 줄어드는 시간

                    if (worlds[s] == null) worlds[s] = new ArrayList<>();

                    worlds[s].add(new Route(e, -t));
                }

                int min = 0;
                for (int j=1; j<=n; j++) {
                    min = timeTravel(n, 1);
                }
                String success = min < 0 ? "YES" : "NO";
                result.append(success).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static int timeTravel(int n, int node) {
//        PriorityQueue<Route> queue = new PriorityQueue<>(worlds[node]);
        Queue<Route> queue = new ArrayDeque<>(worlds[node]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        for (Route route : worlds[node]) {
            dist[route.end] = route.time;
        }

        while (!queue.isEmpty()) {
            Route route = queue.poll();

            for (Route nextRoute : worlds[route.end]) {
                if (dist[nextRoute.end] >= 0 && dist[nextRoute.end] > dist[route.end] + nextRoute.time) {
                    dist[nextRoute.end] = dist[route.end] + nextRoute.time;
                    queue.add(nextRoute);
                }
            }
        }

        return dist[node];
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

        @Override
        public String toString() {
            return "Route{" +
                    "end=" + end +
                    ", time=" + time +
                    '}';
        }
    }
}
