package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1504_특정한최단경로_1 {
    static final int INF = 200000 * 1000; // 200,000,000

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new ArrayList[n+1];
            for (int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 뒤돌아갔을 때의 경로가 더 최단 경로일 수 있으니 반대로도 탐색해본다.
            // 1 -> start -> end -> n
            int path1 = shortestPath(1, start, graph, n) + shortestPath(start, end, graph, n) + shortestPath(end, n, graph, n);

            // 1 -> end -> start -> n
            int path2 = shortestPath(1, end, graph, n) + shortestPath(end, start, graph, n) + shortestPath(start, n, graph, n);

            int result = path1 >= INF && path2 >= INF ? -1 : Math.min(path1, path2);
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static int shortestPath(int start, int end, List<Node>[] graph, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n+1];

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.end == end) break;

            if (visited[node.end] || dist[node.end] > INF) continue;

            visited[node.end] = true;

            for (Node next : graph[node.end]) {
                if (dist[next.end] > dist[node.end] + next.value) {
                    dist[next.end] = dist[node.end] + next.value;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
