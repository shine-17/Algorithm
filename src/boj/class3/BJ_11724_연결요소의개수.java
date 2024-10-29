package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {

    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] connections;
    static boolean[] visited;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            connections = new ArrayList[n+1];
            visited = new boolean[n+1];

            for(int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(!graph[u].contains(v)) graph[u].add(v);
                if(!graph[v].contains(u)) graph[v].add(u);
            }

            for(int i=1; i<graph.length; i++) {
                dfs(i, i);
            }

            int count = 0;
            for(ArrayList<Integer> list : connections) {
                if(list != null) count++;
            }

            System.out.println(count);

        } catch(Exception ignored) {}
    }

    static void dfs(int start, int n) {
        if(visited[n]) return;

        if(connections[start] == null) connections[start] = new ArrayList<>();

        visited[n] = true;

        for(Integer node : graph[n]) {
            if(!visited[node]) {
                connections[start].add(node);
                dfs(start, node);
            }
        }

    }
}
