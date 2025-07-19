package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1_2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());

            int[][] pipes = new int[n][n];
            int[][][] dp = new int[n][n][3]; // 0: 가로, 1: 세로, 2: 대각선

            for (int i=0; i<n; i++) {
                pipes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            dp[0][1][0] = 1;

            for (int i=0; i<n; i++) {
                for (int j=2; j<n; j++) {
                    if (isWall(pipes[i][j])) continue;

                    // 가로
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];

                    // 세로
                    if (i > 0) {
                        dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                    }

                    // 대각선
                    if (i > 0 && !isWall(pipes[i][j-1], pipes[i-1][j], pipes[i-1][j-1])) {
                        dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    }
                }
            }

            int result = Arrays.stream(dp[n-1][n-1]).sum();

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static boolean isWall(int... arr) {
        for (Integer num : arr) {
            if (num == 1) return true;
        }

        return false;
    }
}
