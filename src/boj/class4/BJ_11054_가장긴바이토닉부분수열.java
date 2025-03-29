package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            int[] dp = new int[n];

            String[] split = br.readLine().split(" ");
            for (int i=0; i<split.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            for (int i=0; i<n; i++) {
                for (int j=i; j>=0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }

            int[] dp2 = new int[n];
            for (int i=n-1; i>=0; i--) {
                for (int j=i; j<n; j++) {
                    if (arr[i] > arr[j]) {
                        dp2[i] = Math.max(dp2[i], dp2[j]+1);
                    }
                }

            }

            int max = 0;
            for (int i=0; i<n; i++) {
                max = Math.max(max, dp[i] + dp2[i]);
            }

            System.out.println(max + 1);

        } catch (Exception ignored) {}
    }
}
