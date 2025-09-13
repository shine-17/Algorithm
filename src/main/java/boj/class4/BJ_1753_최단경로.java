package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {
    static int v;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[] graph;
    static final int INF = 300000 * 10;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            // 1번 정점 -> N번 정점 최단거리
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            visited = new boolean[v + 1];
            dist = new int[v + 1];
            graph = new ArrayList[v + 1];
            for (int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, c));
            }

            dijkstra(k);
            StringBuilder result = new StringBuilder();

            for (int i=1; i<=v; i++) {
                if (i == k) result.append(0).append("\n");
                else {
                    int weight = dist[i];
                    result.append(weight >= INF ? "INF" : weight).append("\n");
                }
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void dijkstra(int start) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.end]) {
                visited[node.end] = true;

                for (Node newNode : graph[node.end]) {
                    if (!visited[newNode.end] && dist[newNode.end] > dist[node.end] + newNode.v) {
                        dist[newNode.end] = dist[node.end] + newNode.v;
                        pq.add(new Node(newNode.end, dist[newNode.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int v;

        public Node(int end, int v) {
            this.end = end;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }
}
