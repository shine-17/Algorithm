package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1149_RGB거리_2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            int[][] rgbs = new int[n][3];
            int[][] dp = new int[n][3];

            for (int i=0; i<n; i++) {
                rgbs[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // Stream으로 변환하는 것보다 20ms 더 빠름
//            for (int i=0; i<n; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//
//                int r = Integer.parseInt(st.nextToken());
//                int g = Integer.parseInt(st.nextToken());
//                int b = Integer.parseInt(st.nextToken());
//
//                rgbs[i] = new int[] {r, g, b};
//            }

            /*
                1번 집의 색은 2번 집의 색과 같지 않아야 한다.
                N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
                i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
             */

            dp[0][0] = rgbs[0][0];
            dp[0][1] = rgbs[0][1];
            dp[0][2] = rgbs[0][2];

            for (int i=1; i<n; i++) {
                dp[i][0] += rgbs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] += rgbs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] += rgbs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }

            int result = Arrays.stream(dp[n - 1]).min().orElse(0);
            System.out.println(result);

        } catch (Exception ignored) {}
    }
}
