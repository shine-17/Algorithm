package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14938_서강그라운드_1 {
    static int[] grounds;
    static ArrayList<Node>[] routes;
    static int max = Integer.MIN_VALUE;
    static int n, m;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());               // 지역 개수
            m = Integer.parseInt(st.nextToken());               // 수색 범위
            int r = Integer.parseInt(st.nextToken());           // 길의 개수

            String[] split = br.readLine().split(" ");   // 각 구역의 아이템 수
            grounds = new int[n+1];
            for (int i=0; i<split.length; i++) {
                grounds[i+1] = Integer.parseInt(split[i]);
            }

            routes = new ArrayList[n+1];
            for (int i=0; i<routes.length; i++) {
                routes[i] = new ArrayList<>();
            }

            for (int i=0; i<r; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());       // 시작 지역 번호
                int b = Integer.parseInt(st.nextToken());       // 종료 지역 번호
                int l = Integer.parseInt(st.nextToken());       // 길의 길이

                Node node1 = new Node(b, l);
                routes[a].add(node1);

                Node node2 = new Node(a, l);
                routes[b].add(node2);
            }

            for (int i=1; i<=n; i++) {
                bfs(i);
            }

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void bfs(int start) {
        int sum = 0;
        int[] dist = new int[n+1];

        Arrays.fill(dist, 1500);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (dist[node.end] < node.length) continue;

            sum += grounds[node.end];

            for (Node nextNode : routes[node.end]) {

                if (dist[node.end] + nextNode.length <= m && dist[nextNode.end] > dist[node.end] + nextNode.length) {
                    dist[nextNode.end] = dist[node.end] + nextNode.length;
//                    queue.add(nextNode);
                    queue.add(new Node(nextNode.end, dist[nextNode.end]));
                }
            }
        }

        max = Math.max(max, sum);
    }

    static class Node implements Comparable<Node> {
        int end;
        int length;

        public Node(int end, int length) {
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}
