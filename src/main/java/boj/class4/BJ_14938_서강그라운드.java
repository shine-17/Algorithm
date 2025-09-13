package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

//            bfs(1);

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void bfs(int start) {
        PriorityQueue<Route> queue = new PriorityQueue<>(routes[start]);
        int sum = grounds[start];
        int[][] distance = new int[n+1][2];

        while (!queue.isEmpty()) {
            Route route = queue.poll();

            // start, end
            long dist = distance[route.start][0] + route.length;

            if (dist <= m && distance[route.start][1] + grounds[route.end] >= distance[route.end][1]) {
                distance[route.end][0] = distance[route.start][0] + route.length;
                distance[route.end][1] = distance[route.start][1] + grounds[route.end];
                sum += grounds[route.end];

//                System.out.println("start: " + route.start + " end: " + route.end + ", value: " + grounds[route.end] + ", length: " + distance[route.end][0]);
                queue.addAll(routes[route.end]);
            }
        }

//        for (int i=0; i<distance.length; i++) {
//            int[] arr = distance[i];
//            sum += arr[1];
//
////            System.out.println("i: " + i + ", arr[1]: " + arr[1]);
//        }

//        System.out.println("start: " + start + ", sum: " + sum);
        max = Math.max(max, sum);
    }

    static class Route implements Comparable<Route> {
        int start;
        int end;
        int length;

        public Route(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }

        @Override
        public int compareTo(Route o) {
            if (this.length == o.length) return -1;

            return this.length - o.length;
        }
    }
}
