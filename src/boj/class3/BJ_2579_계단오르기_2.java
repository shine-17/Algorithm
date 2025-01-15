package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2579_계단오르기_2 {
    static int[] scores;
    static Integer[] dp;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            /*
                계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
                연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
                마지막 도착 계단은 반드시 밟아야 한다.

                n+1 또는 n+2
                n, n+1, n+2 연속 3계단은 불가능
             */

            int n = Integer.parseInt(br.readLine());
            scores = new int[n+1];
            dp = new Integer[n+1];

            for(int i=1; i<=n; i++) {
                scores[i] = Integer.parseInt(br.readLine());
            }

            // 초기값 설정
            dp[0] = scores[0];
            dp[1] = scores[1];
            if(n >= 2) dp[2] = scores[1] + scores[2];

            /*
                점화식
                n = Math.max(dp[n-2], dp[n-3] + scores[n-1]) + scores[n]
             */
            for(int i=3; i<=n; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3] + scores[i-1]) + scores[i];
            }

            System.out.println(dp[n]);

        } catch(Exception ignored) {}
    }


}
