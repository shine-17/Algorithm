package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9251_LCS_1 {
    static char[] first;
    static char[] second;
    static Integer[][] dp;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String str1 = br.readLine();
            String str2 = br.readLine();

            first = str1.toCharArray();
            second = str2.toCharArray();

            dp = new Integer[str1.length()][str2.length()];

            int result = lcs(first.length-1, second.length-1);
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static int lcs(int x, int y) {
        if (x < 0 || y < 0) return 0;

        if (dp[x][y] == null) {
            if (first[x] == second[y]) {
                dp[x][y] = lcs(x - 1, y - 1) + 1;
            }
            else {
                dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }

        return dp[x][y];
    }
}
