package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1932_정수삼각형_1 {
    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            triangle = new int[n][n+1];
            dp = new int[n][n+1];

            for (int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");

                for (int j=0; j< split.length; j++) {
                    triangle[i][j+1] = Integer.parseInt(split[j]);
                }
            }

            dp[0][1] = triangle[0][1];

            int column = 2;

            for (int i=1; i<n; i++) {
                for (int j=1; j<=column; j++) {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
                column++;
            }

            int max = Arrays.stream(dp[n - 1]).max().orElse(0);
            System.out.println(max);

        } catch (Exception ignored) {}
    }
}
