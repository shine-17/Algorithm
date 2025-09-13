package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1_1 {
    static int[][] homes;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            homes = new int[n+1][n+1];

            for (int i=1; i<=n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=1; j<=n; j++) {
                    homes[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(findPipePath(n));

        } catch (Exception ignored) {}
    }

    static int findPipePath(int n) {
        Queue<int[]> queue = new ArrayDeque<>();

        // 파이프 (1,1) (1,2) 고정, (1,2) 시작

        queue.add(new int[]{1, 2, 0});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            /*
                가로, 세로, 대각선

                1. 벽이 있으면 진행 X, 대각선은 3개 칸이 벽이면 안됨
                2. 가로, 세로는 마지막 인덱스에 접근X 대각선만 가능
             */

//            System.out.println(home.x + " " + home.y + " " + home.form);

            // 도착
            if (arr[0] == n && arr[1] == n) {
                count++;
                continue;
            }

            // 가로: 가로, 대각선 가능
            if (arr[2] != 1) {
                if (arr[1] + 1 <= n && homes[arr[0]][arr[1] + 1] == 0) queue.add(new int[]{arr[0], arr[1] + 1, 0});
            }

            // 세로: 세로, 대각선 가능
            if (arr[2] != 0) {
                if (arr[0] + 1 <= n && homes[arr[0] + 1][arr[1]] == 0) queue.add(new int[]{arr[0] + 1, arr[1], 1});
            }

            // 대각선: 가로, 세로, 대각선 모두 가능
            if (arr[0] + 1 <= n && arr[1] + 1 <= n) {
                if (homes[arr[0] + 1][arr[1]] == 0 && homes[arr[0]][arr[1] + 1] == 0 && homes[arr[0] + 1][arr[1] + 1] == 0)
                    queue.add(new int[]{arr[0] + 1, arr[1] + 1, 2});
            }
        }

        return count;
    }
}
