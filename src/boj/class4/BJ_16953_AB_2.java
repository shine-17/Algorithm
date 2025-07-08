package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16953_AB_2 {
    static int max;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            max = Math.max(a, b) + 1;

            System.out.println(bfs(a, b));

        } catch (Exception ignored) {}
    }

    static int bfs(int a, int b) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(a, 0));

        int result = -1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.value == b) return node.count+1;

            if (node.value * 2 < max) {
                queue.add(new Node(node.value*2, node.count+1));
            }
            if (node.plusOne() < max) {
                queue.add(new Node(node.plusOne(), node.count+1));
            }
        }

        return result;
    }

    static class Node {
        long value;
        int count;

        public Node(long value, int count) {
            this.value = value;
            this.count = count;
        }

        public long plusOne() {
            return Long.parseLong(value + "1");
        }
    }
}
