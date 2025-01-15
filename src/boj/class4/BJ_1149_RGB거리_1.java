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

                homes[i][0] = r;
                homes[i][1] = g;
                homes[i][2] = b;
            }

            int[][] dp = new int[n][3];

            for (int i=0; i<3; i++) {
                dp[0][i] = homes[0][i];

                int index = i;

                for (int j=1; j<homes.length; j++) {
                    switch (index) {
                        case 0 -> {
                            dp[j][i] = dp[j-1][i] + Math.min(homes[j][1], homes[j][2]);
                            index = homes[j][1] < homes[j][2] ? 1 : 2;
                        }
                        case 1 -> {
                            dp[j][i] = dp[j-1][i] + Math.min(homes[j][0], homes[j][2]);
                            index = homes[j][0] < homes[j][2] ? 0 : 2;
                        }
                        case 2 -> {
                            dp[j][i] = dp[j-1][i] + Math.min(homes[j][0], homes[j][1]);
                            index = homes[j][0] < homes[j][1] ? 0 : 1;
                        }
                    }
                }
            }

            for (int i=0; i<dp.length; i++) {
                for (int j=0; j<dp[0].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
