package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            int[] dp = new int[n];
            int max = 0;

            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=0; i<n; i++) {
                for (int j=i; j>=0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }

                max = Math.max(max, dp[i]);
            }

            System.out.println(max + 1);

        } catch (Exception ignored) {}
    }
}
