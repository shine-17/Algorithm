package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465_스티커_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();

            for (int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());

                int[][] arr = new int[2][n+1];
                int[][] dp = new int[2][n+1];

                for (int j=0; j<2; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());

                    for (int k=1; k<=n; k++) {
                        arr[j][k] = Integer.parseInt(st.nextToken());
                    }
                }

                dp[0][1] = arr[0][1];
                dp[1][1] = arr[1][1];

                for (int j=2; j<=n; j++) {
                    dp[0][j] = arr[0][j] + Math.max(dp[1][j-2], dp[1][j-1]);
                    dp[1][j] = arr[1][j] + Math.max(dp[0][j-2], dp[0][j-1]);
                }

                int max = Math.max(dp[0][n], dp[1][n]);
                result.append(max).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }
}
