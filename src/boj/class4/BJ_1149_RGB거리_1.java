package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리_1 {
    static int[][] homes;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            homes = new int[n][3];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                homes[i] = new int[] {r, g, b};
            }

            int[][] dp = new int[n][3];
            dp[0][0] = homes[0][0];
            dp[0][1] = homes[0][1];
            dp[0][2] = homes[0][2];

            for (int j=1; j<homes.length; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + homes[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + homes[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + homes[j][2];
            }

            System.out.println(Arrays.stream(dp[n - 1]).min().getAsInt());

        } catch (Exception ignored) {}
    }
}
