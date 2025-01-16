package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
    static int[][] homes;
    static int[][] dp;
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static final int[] rgbs = {RED, GREEN, BLUE};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            homes = new int[n][3];
            dp = new int[n][3];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                homes[i] = new int[] {r, g, b};
            }

            dp[0][0] = homes[0][0];
            dp[0][1] = homes[0][1];
            dp[0][2] = homes[0][2];

            int min = Integer.MAX_VALUE;
            for (int color : rgbs) {
                min = Math.min(min, findRGB(n - 1, color));
            }
            System.out.println(min);

        } catch (Exception ignored) {}
    }

    static int findRGB(int n, int color) {

        if (dp[n][color] == 0) {
            if (color == RED) {
                dp[n][color] = Math.min(findRGB(n-1, GREEN), findRGB(n-1, BLUE)) + homes[n][color];
            }
            else if (color == GREEN) {
                dp[n][color] = Math.min(findRGB(n-1, RED), findRGB(n-1, BLUE)) + homes[n][color];
            }
            else if (color == BLUE) {
                dp[n][color] = Math.min(findRGB(n-1, RED), findRGB(n-1, GREEN)) + homes[n][color];
            }
        }

        return dp[n][color];
    }

}
