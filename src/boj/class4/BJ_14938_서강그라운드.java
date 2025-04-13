package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14938_서강그라운드 {
    static int[] grounds;
    static ArrayList<Route>[] routes;
    static int max = Integer.MIN_VALUE;
    static int n, m;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());               // 지역 개수
            m = Integer.parseInt(st.nextToken());               // 수색 범위
            int r = Integer.parseInt(st.nextToken());           // 길의 개수

            String[] split = br.readLine().split(" ");   // 각 구역의 아이템 수
            grounds = new int[n+1];
            for (int i=0; i<split.length; i++) {
                grounds[i+1] = Integer.parseInt(split[i]);
            }

            routes = new ArrayList[n+1];
            for (int i=0; i<routes.length; i++) {
                routes[i] = new ArrayList<>();
            }

            for (int i=0; i<r; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());       // 시작 지역 번호
                int b = Integer.parseInt(st.nextToken());       // 종료 지역 번호
                int l = Integer.parseInt(st.nextToken());       // 길의 길이

                Route route1 = new Route(a, b, l);
                routes[a].add(route1);

                Route route2 = new Route(b, a, l);
                routes[b].add(route2);
            }

            for (int i=1; i<=n; i++) {
                bfs(i);
            }

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void bfs(int start) {
        Queue<Route> queue = new ArrayDeque<>(routes[start]);
        int sum = grounds[start];
        int[][] distance = new int[n+1][2];

        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Route route = queue.poll();

            if (!visited[route.end]) {
                visited[route.end] = true;

                distance[route.end][0] = distance[route.start][0] + route.length;

                // start, end
                if (distance[route.end][0] <= m) {
                    distance[route.end][1] += grounds[route.end];
                    System.out.println("start: " + route.start + " end: " + route.end + ", value: " + grounds[route.end]);

                    if (!routes[route.end].isEmpty()) {
                        queue.addAll(routes[route.end]);
                    }
//                    else {
//                        sum += distance[route.start][1];
//                    }
                }
                else {
//                    System.out.println("start: " + route.start + " end: " + route.end + ", value: " + distance[route.start][1]);
                    sum += distance[route.start][1];
                }
            }

//            for (Route newRoute : routes[route.end]) {
//                if (visited[newRoute.end]) continue;
//
//                visited[newRoute.end] = true;
//
//                if (distance[route.end][0] + route.length <= m) {
//                    distance[route.end][0] += route.length;
//                    distance[route.end][1] += grounds[route.end];
//                }
//                else {
//                    sum += distance[route.end][1];
//                }
//            }
        }

//        System.out.println("start: " + start + ", sum: " + sum);
        max = Math.max(max, sum);
    }

    static class Route {
        int start;
        int end;
        int length;

        public Route(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}
