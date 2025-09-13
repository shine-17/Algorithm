package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2606_1 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = null;
            int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (정점)
            int m = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수 (간선)
            int start = 1; // 시작 노드

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                if(graph[index] == null) graph[index] = new ArrayList<>();
                if(graph[value] == null) graph[value] = new ArrayList<>();

                graph[index].add(value);
                graph[value].add(index);
            }

            dfs(start);

            System.out.println(count);

        } catch(Exception ignored) {}
    }

    static void dfs(int n) {
        visited[n] = true;

        if(graph[n] == null) return;

        for(Integer node : graph[n]) {
            if(!visited[node]) {
                count++;
                dfs(node);
            }
        }
    }
}
