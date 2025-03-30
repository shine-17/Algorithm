package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11404_플로이드 {
    static int n;
    static int[][] routes;
    static HashMap<Integer, List<Route>> routeMap = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            n = Integer.parseInt(br.readLine()); // 도시의 개수
            int m = Integer.parseInt(br.readLine()); // 버스의 개수

            routes = new int[n+1][n+1];

            for (int i=0; i<m; i++) {
                st  = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()); // 시작 도시
                int b = Integer.parseInt(st.nextToken()); // 도착 도시
                int c = Integer.parseInt(st.nextToken()); // 비용

                routeMap.putIfAbsent(a, new ArrayList<>());
                routeMap.get(a).add(new Route(a, b, c));
            }

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    bfs(i, j);
                }
            }

            StringBuilder result = new StringBuilder();

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    result.append(routes[i][j]).append(" ");
                }
                result.append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void bfs(int start, int end) {
        if (!routeMap.containsKey(start) || start == end) return;

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Route> queue = new PriorityQueue<>(routeMap.get(start));

        while (!queue.isEmpty()) {
            Route route = queue.poll();

            if (route.end == end) {
                routes[start][end] = route.costSum;
                break;
            }

            if (!visited[route.end]) {
                visited[route.end] = true;

                for (Route newRoute : routeMap.get(route.end)) {
                    newRoute.costSum += route.costSum;
                }

                queue.addAll(routeMap.get(route.end));
            }
        }

        // costSum 초기화
        for (Integer key : routeMap.keySet()) {
            for (Route route : routeMap.get(key)) {
                route.costSum = route.cost;
            }
        }
    }

    static class Route implements Comparable<Route> {
        int start;
        int end;
        final int cost;
        int costSum;

        public Route(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
            this.costSum = cost;
        }

        @Override
        public int compareTo(Route o) {
            return this.costSum - o.costSum;
        }
    }
}
