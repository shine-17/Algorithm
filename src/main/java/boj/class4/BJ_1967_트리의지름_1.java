package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1967_트리의지름_1 {
    static ArrayList<Node>[] tree;
    static ArrayList<Node>[] tree2;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());

            tree = new ArrayList[n+1];
            for (int i=0; i<tree.length; i++) {
                tree[i] = new ArrayList<>();
            }
            tree2 = new ArrayList[n+1];
            for (int i=0; i<tree2.length; i++) {
                tree2[i] = new ArrayList<>();
            }

            for (int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                tree[start].add(new Node(end, weight));
                tree2[start].add(new Node(end, weight));
                tree2[end].add(new Node(start, weight));
            }

            Node max = bfs(1, tree);
//            System.out.println("node: " + max.end + ", weight: " + max.weight);
//            System.out.println("---------------------------");

            Node result = bfs(max.end, tree2);
            System.out.println(result.weight);

        } catch (Exception ignored) {}
    }

    static Node bfs(int start, ArrayList<Node>[] tree) {
        int[] dist = new int[tree.length];
        Node max = new Node(0, 0);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) ->  o2.weight - o1.weight));
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[tree.length];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.end]) continue;
            visited[node.end] = true;

            for (Node newNode : tree[node.end]) {
                if (dist[newNode.end] < dist[node.end] + newNode.weight) {
                    dist[newNode.end] = dist[node.end] + newNode.weight;
                    pq.offer(new Node(newNode.end, dist[newNode.end]));

                    if (!visited[newNode.end] && dist[newNode.end] > max.weight) {
                        max = new Node(newNode.end, dist[newNode.end]);
                    }
                }
            }
        }

//        return Arrays.stream(dist).max().getAsInt();
        return max;
    }

    static void dfs(Node node) {
        if (node == null) return;






    }

    static class Node {
        Integer end;
        Integer weight;

        public Node(Integer end, Integer weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
