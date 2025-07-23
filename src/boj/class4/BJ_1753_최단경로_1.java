package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1753_최단경로_1 {
    static final int INF = 300000 * 10;
    static int[] dist;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(br.readLine());

            List<Node>[] graph = new ArrayList[v+1];

            for (int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v1 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v1, w));
            }

            StringBuilder result = new StringBuilder();
            dist = new int[v+1];
            find(k, v, graph);

            for (int i=1; i<=v; i++) {
//                int shortest = find(k, i, v, graph);
//                result.append(shortest == INF ? "INF" : shortest).append("\n");

//                find(k, i, v, graph);
                result.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
            }
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void find(int start, int v, List<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));

//        int[] dist = new int[v+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean[] visited = new boolean[v+1];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

//            if (node.end == end) break;

            if (visited[node.end]) continue;
            visited[node.end] = true;

            for (Node newNode : graph[node.end]) {
                if (dist[newNode.end] > dist[node.end] + newNode.weight) {
                    dist[newNode.end] = dist[node.end] + newNode.weight;
                    pq.offer(new Node(newNode.end, dist[newNode.end]));
                }
            }
        }

//        return dist[end];
    }

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
