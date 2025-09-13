package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭 {
    static Integer[][] dp;
    static int[] w;
    static int[] v;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            dp = new Integer[n][k + 1];
            w = new int[n];
            v = new int[n];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                w[i] = Integer.parseInt(st.nextToken());
                v[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(findMaxValue(n - 1, k));

        } catch (Exception ignored) {}
    }

    static int findMaxValue(int i, int k) {

        if (i < 0) return 0;

        if (dp[i][k] == null) {
            // 배낭에 넣을 자리가 남았을 때, Math.max(이전 값, 현재 무게의 가치 + k에서 현재 무게를 뺀 무게의 가치)
            if (w[i] <= k) {
                dp[i][k] = Math.max(findMaxValue(i - 1, k), v[i] + findMaxValue(i - 1, k - w[i]));
            }
            else {
                dp[i][k] = findMaxValue(i - 1, k);
            }
        }

        return dp[i][k];
    }
}
