package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11053_가장긴증가하는부분수열_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dp = new int[n];
            dp[0] = 1;

            for (int i=1; i<arr.length; i++) {
                if (arr[i] > arr[i-1]) {
                    dp[i] = dp[i-1]+1;
                }

                for (int j=i-1; j>=0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }

                dp[i] = Math.max(dp[i], 1);
            }

            System.out.println(Arrays.stream(dp).max().getAsInt());

        } catch (Exception ignored) {}
    }
}
