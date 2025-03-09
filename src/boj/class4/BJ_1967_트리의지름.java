package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1967_트리의지름 {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];
            for (int i=1; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, w));
                graph[b].add(new Node(a, w));
            }

            for (int i=1; i<=n; i++) {
                Arrays.fill(visited, false);
                dfs(i, 0);
            }

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void dfs(int node, int sum) {
        visited[node] = true;
        max = Math.max(max, sum);

        for (Node newNode : graph[node]) {
            if (!visited[newNode.end]) {
                dfs(newNode.end, sum + newNode.v);
            }
        }
    }


    static class Node {
        int end;
        int v;

        public Node(int end, int v) {
            this.end = end;
            this.v = v;
        }
    }
}
