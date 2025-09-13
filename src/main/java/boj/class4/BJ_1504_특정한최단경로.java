package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1504_특정한최단경로 {
    static ArrayList<Node>[] graph;
    static final int INF = 200000 * 1000;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            // 1번 정점 -> N번 정점 최단거리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(a, b, c));
                graph[b].add(new Node(b, a, c));
            }

            // 반드시 거쳐야 하는 두 개의 정점
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            // start -> v1 -> v2 -> end
            long root1 = bfs(n, 1, v1) + bfs(n, v1, v2) + bfs(n, v2, n);
            // start -> v2 -> v1 -> end
            long root2 = bfs(n, 1, v2) + bfs(n, v2, v1) + bfs(n, v1, n);

            long result = root1 >= INF && root2 >= INF ? -1 : Math.min(root1, root2);
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static long bfs(int n, int start, int end) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.end]) {
                visited[node.end] = true;

                for (Node nextNode : graph[node.end]) {
                    if (dist[nextNode.end] > dist[node.end] + nextNode.v) {
                        dist[nextNode.end] = dist[node.end] + nextNode.v;
                        pq.add(new Node(nextNode.start, nextNode.end, dist[nextNode.end]));
                    }
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int v;

        public Node(int start, int end, int v) {
            this.start = start;
            this.end = end;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }
}
