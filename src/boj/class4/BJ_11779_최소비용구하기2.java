package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11779_최소비용구하기2 {
    static ArrayList<Route>[] citys;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            citys = new ArrayList[n+1];
            for (int i=0; i<citys.length; i++) {
                citys[i] = new ArrayList<>();
            }

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                citys[start].add(new Route(end, cost));
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            findMinimumCost(start, end);

        } catch (Exception ignored) {}
    }

    static void findMinimumCost(int start, int end) {
        PriorityQueue<Route> queue = new PriorityQueue<>();
        queue.add(new Route(start, 0));
        boolean[] visited = new boolean[citys.length];

        int[] dist = new int[citys.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 역추적 배열
        int[] routes = new int[citys.length];
        routes[start] = 0;

        while (!queue.isEmpty()) {
            Route route = queue.poll();

            if (visited[route.end]) continue;

            visited[route.end] = true;

            for (Route newRoute : citys[route.end]) {
                if (dist[newRoute.end] > dist[route.end] + newRoute.cost) {
                    dist[newRoute.end] = dist[route.end] + newRoute.cost;
                    queue.add(new Route(newRoute.end, dist[newRoute.end]));

                    // 현재 정점에 이전 정점 넣기 (역추적할 수 있도록)
                    routes[newRoute.end] = route.end;
                }
            }
        }

        System.out.println(dist[end]);

        // 역추적
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(end);
        while (routes[end] != 0) {
            stack.push(routes[end]);
            end = routes[end];
        }

        System.out.println(stack.size());
        stack.forEach(node -> System.out.print(node + " "));
    }

    static class Route implements Comparable<Route> {
        int end;
        int cost;

        public Route(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Route o) {
            return this.cost - o.cost;
        }
    }
}
