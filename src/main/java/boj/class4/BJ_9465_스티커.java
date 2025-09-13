package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465_스티커 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        try {

            int t = Integer.parseInt(br.readLine());
            for (int i=0; i<t; i++) {

                int n = Integer.parseInt(br.readLine());
                int[][] stickers = new int[2][n+1];

                for (int j=0; j<stickers.length; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());

                    for (int k=1; k<=n; k++) {
                        stickers[j][k] = Integer.parseInt(st.nextToken());
                    }
                }

                int[][] dp = new int[2][n+1];
                dp[0][1] = stickers[0][1];
                dp[1][1] = stickers[1][1];

                for (int j=2; j<=n; j++) {
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j];
                }

                result.append(Math.max(dp[0][n], dp[1][n])).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }
}
