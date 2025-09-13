package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9251_LCS {
    static Integer[][] dp;
    static char[] firstString;
    static char[] secondString;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            firstString = br.readLine().toCharArray();
            secondString = br.readLine().toCharArray();

            dp = new Integer[firstString.length][secondString.length];

            int maxLength = findLCS(firstString.length - 1, secondString.length - 1);
            System.out.println(maxLength);

        } catch (Exception ignored) {}
    }

    static int findLCS(int x, int y) {

        if (x < 0 || y < 0) return 0;

        if (dp[x][y] == null) {
            // 두 수열의 숫자가 같을 때 이전 LCS에서 +1
            if (firstString[x] == secondString[y]) {
                dp[x][y] = findLCS(x-1 , y-1) + 1;
            }
            // 이전 행이나 이전 열 중 최대값
            else {
                dp[x][y] = Math.max(findLCS(x-1, y), findLCS(x, y-1));
            }
        }

        return dp[x][y];
    }

}
