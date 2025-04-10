package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_12851_숨바꼭질2 {
    static final int INF = 100001;
    static int[] points = new int[INF];
    static int[] mx = {-1, 1, 2};
    static int min = Integer.MAX_VALUE;
    static int count;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            // 5 -> 17

            // 5 -> 10 -> 9 -> 18 -> 17
            // 5 -> 4 -> 8 -> 16 -> 17

            /*
                1 14
                정답: 5 4

                (1,2,4,8,7,14)
                (1,2,3,6,7,14)
                그리고 각각 1->2를 +1로 가거나 *2로 가거나하여 2가지경우가 존재하므로 4개가 됩니다.

             */

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n >= k) {
                System.out.println(n-k);
                System.out.println(1);
                return;
            }

            bfs(n, k);

            System.out.println(min);
            System.out.println(count);

        } catch (Exception ignored) {}
    }

    static void bfs(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        points[n] = 1;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            // 현재 방문시간이 최소 시간보다 크면 최소 시간이 될 수 없으므로 패스
            if (min < points[num]) return;

            for (int i=0; i<mx.length; i++) {
                int next;

                if (i < 2) next = num + mx[i];
                else next = num * mx[i];

                if (next < 0 || next > INF-1) continue;

                if (next == k) {
                    min = points[num];
                    count++;
                }

                if (points[next] == 0 || points[next] == points[num]+1) {
                    queue.add(next);
                    points[next] = points[num]+1;
                }
            }
        }
    }
}
