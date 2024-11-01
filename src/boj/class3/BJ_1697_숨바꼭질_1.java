package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질_1 {
    static boolean[] visited = new boolean[200001];
    static int[] move = {-1, 1, 2};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            System.out.println(find(n, k));

        } catch(Exception ignored) {}
    }

    static long find(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        long[] distance = new long[200001];

        visited[start] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            /*
            1. n-1
            2. n+1
            3. n*2
             */

            for(int i=0; i<move.length; i++) {
                int next;

                if(i == 2) next = n * move[i];
                else next = n + move[i];

                if(next >= 0 && next <= 150000 && !visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[n] + 1;
                    queue.add(next);
                }
            }

            if(end == n) return distance[end];
        }

        return distance[end];
    }
}
