package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_11725_트리의부모찾기_3 {
    static int n;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static int[] arr;


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            n = Integer.parseInt(br.readLine());
            tree = new ArrayList[n+1];
            arr = new int[n+1];
            visited = new boolean[n+1];
            for (int i=0; i<tree.length; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree[a].add(b);
                tree[b].add(a);
            }

            dfs(1);

            StringBuilder result = new StringBuilder();

            for (int i=2; i<=n; i++) {
                result.append(arr[i]).append("\n");
            }
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void dfs(int parent) {
        visited[parent] = true;

        for (Integer node : tree[parent]) {
            if (visited[node]) continue;
            arr[node] = parent;
            dfs(node);
        }
    }
}
