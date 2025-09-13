package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11403_경로찾기 {

    static ArrayList<Integer>[] graph;
    static int n;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            n = Integer.parseInt(br.readLine());

            graph = new ArrayList[n+1];
            for(int i=1; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=1; i<=n; i++) {
                String[] split = br.readLine().split(" ");

                for(int j=0; j<split.length; j++) {
                    int num = Integer.parseInt(split[j]);

                    if(num > 0) graph[i].add(j+1);
                }
            }

            StringBuilder result = new StringBuilder();

            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    result.append(findPath(i, j)).append(" ");
                }
                result.append("\n");
            }

            System.out.println(result);

        } catch(Exception ignored) {}
    }

    static int findPath(int i, int j) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            Integer num = queue.poll();
            ArrayList<Integer> linked = graph[num];
            if(linked == null) continue;

            for(int node : linked) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

        return visited[j] ? 1 : 0;
    }
}
