package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1967_트리의지름_2 {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int maxNode;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());

            tree = new ArrayList[n+1];
            for (int i=0; i<tree.length; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                tree[start].add(new Node(end, weight));
                tree[end].add(new Node(start, weight));
            }


            int start = 1; // 아무 노드로 시작해도 상관없음.

            visited = new boolean[n+1];
            visited[1] = true;
            dfs(start, 0);

            visited = new boolean[n+1];
            visited[maxNode] = true;
            dfs(maxNode, 0);

            System.out.println(max);

        } catch (Exception ignored) {}
    }


    static void dfs(int node, int sum) {
        if (max < sum) {
            max = sum;
            maxNode = node;
        }

        for (Node newNode : tree[node]) {
            if (!visited[newNode.end]) {
                visited[newNode.end] = true;
                dfs(newNode.end, sum + newNode.weight);
            }
        }
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
