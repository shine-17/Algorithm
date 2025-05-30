package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// dfs
// https://moonsbeen.tistory.com/101
public class BJ_1167_트리의지름 {
    static ArrayList<Node>[] trees;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int node;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int v = Integer.parseInt(br.readLine());
            trees = new ArrayList[v+1];
            visited = new boolean[v+1];

            for (int i=0; i<trees.length; i++) {
                trees[i] = new ArrayList<>();
            }

            for (int i=0; i<v; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());

                while (st.hasMoreTokens()) {
                    int m = Integer.parseInt(st.nextToken());
                    if (m == -1) break;
                    int length = Integer.parseInt(st.nextToken());

                    trees[n].add(new Node(m, length));
                }
            }

            // 임의의 한 정점에서 가장 먼 정점까지의 경로 중
            // 각 모든 정점에서 가장 먼 정점까지의 경로의 일부와 항상 겹친다.
            // (정점 간 cost를 기준으로 경로가 결정되기 때문에 높은 cost가 포함된 경로가 항상 겹칠 수 밖에 없다.)
            // 이 말은 해당 트리에서 최장거리에 포함된 두 정점 중 하나는 겹치는 경로에 포함된다는 말이다.

            // 그래서 임의의 한 정점에서 가장 먼 정점까지 최장거리를 구한 후 (dfs)
            // 위에서 구한 가장 먼 정점에서 시작해서 최장거리를 구하면 (dfs) 트리에서의 최장거리가 나온다.

            // 이 방법은 양방향 트리에서만 가능할 것 같다?

            Arrays.fill(visited, false);
            dfs(1, 0);

            Arrays.fill(visited, false);
            dfs(node, 0);

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void dfs(int i, int sum) {
        visited[i] = true;

        if (sum > max) {
            max = sum;
            node = i;
        }

        for (Node node : trees[i]) {
            if (!visited[node.end]) {
                dfs(node.end, sum + node.cost);
            }
        }
    }

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
