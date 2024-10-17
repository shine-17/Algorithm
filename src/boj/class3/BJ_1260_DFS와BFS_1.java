package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1260_DFS와BFS_1 {

    static ArrayList<Integer>[] graph;
    static List<Integer> dfs;
    static List<Integer> bfs;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 정점의 개수
            int m = Integer.parseInt(st.nextToken()); // 간선의 개수
            int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

            graph = new ArrayList[n+1];
            visited = new boolean[n+1];
            dfs = new ArrayList<>();
            bfs = new ArrayList<>();

            for(int i=1; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!graph[a].contains(b)) graph[a].add(b);
                if(!graph[b].contains(a)) graph[b].add(a);
            }

            for(int i=1; i<graph.length; i++) {
                Collections.sort(graph[i]);
            }

            dfs(v);
            visited = new boolean[n+1];
            bfs(v);

            StringBuilder sb = new StringBuilder();

            for(Integer i : dfs) sb.append(i).append(" ");
            sb.append("\n");
            for(Integer i : bfs) sb.append(i).append(" ");

            System.out.println(sb);

        } catch(Exception ignored) {}
    }

    static void dfs(int v) {
        if(!visited[v]) {
            visited[v] = true;
            dfs.add(v);

            for(Integer i : graph[v]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        visited[v] = true;
        bfs.add(v);
        queue.addAll(graph[v]);

        while(!queue.isEmpty()) {
            int n = queue.poll();

            if(!visited[n]) {
                visited[n] = true;
                bfs(n);
            }
        }
    }
}
