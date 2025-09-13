package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2096_내려가기_2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            int[] arr;

            int[][] max_dp = new int[2][3];
            int[][] min_dp = new int[2][3];

            final int prev = 0;
            final int next = 1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            min_dp[0][0] = max_dp[0][0] = Integer.parseInt(st.nextToken());
            min_dp[0][1] = max_dp[0][1] = Integer.parseInt(st.nextToken());
            min_dp[0][2] = max_dp[0][2] = Integer.parseInt(st.nextToken());

            for (int i=1; i<n; i++) {
                arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                max_dp[next][0] = arr[0] + Math.max(max_dp[prev][0], max_dp[prev][1]);
                max_dp[next][1] = arr[1] + Math.max(Math.max(max_dp[prev][0], max_dp[prev][1]), max_dp[prev][2]);
                max_dp[next][2] = arr[2] + Math.max(max_dp[prev][1], max_dp[prev][2]);
                max_dp[prev][0] = max_dp[next][0];
                max_dp[prev][1] = max_dp[next][1];
                max_dp[prev][2] = max_dp[next][2];

                min_dp[next][0] = arr[0] + Math.min(min_dp[prev][0], min_dp[prev][1]);
                min_dp[next][1] = arr[1] + Math.min(Math.min(min_dp[prev][0], min_dp[prev][1]), min_dp[prev][2]);
                min_dp[next][2] = arr[2] + Math.min(min_dp[prev][1], min_dp[prev][2]);
                min_dp[prev][0] = min_dp[next][0];
                min_dp[prev][1] = min_dp[next][1];
                min_dp[prev][2] = min_dp[next][2];
            }

            int max = Arrays.stream(max_dp[0]).max().orElse(0);
            int min = Arrays.stream(min_dp[0]).min().orElse(0);

            System.out.println(max + " " + min);

        } catch (Exception ignored) {}
    }
}
