package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_17626_FourSquares {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];

            dp[0] = 0;
            dp[1] = 1;

            for(int i=2; i<=n; i++) {
                int min = Integer.MAX_VALUE;

                for(int j=1; j<=i; j++) {
                    int num = (int) Math.pow(j, 2);

                    if(num > i) break;

                    if(min > dp[i-num]) min = dp[i-num];
                }

                dp[i] = ++min;
            }

            System.out.println(dp[n]);

        } catch(Exception ignored) {}
    }
}
