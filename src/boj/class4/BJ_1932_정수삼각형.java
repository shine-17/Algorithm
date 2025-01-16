package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1932_정수삼각형 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] arr = new ArrayList[n];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new ArrayList<>();

                while (st.hasMoreTokens()) {
                    arr[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            int[][] dp = new int[n][n];
            dp[0][0] = arr[0].get(0);

            for (int i=1; i<n; i++) {
                for (int j=0; j<arr[i].size(); j++) {
                    dp[i][j] = Math.max(j > 0 ? dp[i-1][j-1] : 0, j < arr[i].size() - 1 ? dp[i-1][j] : 0) + arr[i].get(j);
                }
            }

            System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());

        } catch (Exception ignored) {}
    }
}
