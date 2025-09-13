package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2096_내려가기 {
    static int n;
    static int[][] max_dp;
    static int[][] min_dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        max_dp = new int[2][3];
        min_dp = new int[2][3];

        st = new StringTokenizer(br.readLine());
        max_dp[0][0] = min_dp[0][0] = Integer.parseInt(st.nextToken());
        max_dp[0][1] = min_dp[0][1] = Integer.parseInt(st.nextToken());
        max_dp[0][2] = min_dp[0][2] = Integer.parseInt(st.nextToken());

        int[] arr;

        for (int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr = new int[3];

            int j=0;
            while (st.hasMoreTokens()) {
                arr[j++] = Integer.parseInt(st.nextToken());
            }

            // max
            for (int k = 0; k<3; k++) {
                switch (k) {
                    case 0 -> max_dp[1][k] = Math.max(max_dp[0][0], max_dp[0][1]) + arr[k];
                    case 1 -> max_dp[1][k] = Math.max(Math.max(max_dp[0][0], max_dp[0][1]), max_dp[0][2]) + arr[k];
                    case 2 -> max_dp[1][k] = Math.max(max_dp[0][1], max_dp[0][2]) + arr[k];
                }
            }
            max_dp[0][0] = max_dp[1][0];
            max_dp[0][1] = max_dp[1][1];
            max_dp[0][2] = max_dp[1][2];

            // min
            for (int k = 0; k< min_dp[0].length; k++) {
                switch (k) {
                    case 0 -> min_dp[1][k] = Math.min(min_dp[0][0], min_dp[0][1]) + arr[k];
                    case 1 -> min_dp[1][k] = Math.min(Math.min(min_dp[0][0], min_dp[0][1]), min_dp[0][2]) + arr[k];
                    case 2 -> min_dp[1][k] = Math.min(min_dp[0][1], min_dp[0][2]) + arr[k];
                }
            }
            min_dp[0][0] = min_dp[1][0];
            min_dp[0][1] = min_dp[1][1];
            min_dp[0][2] = min_dp[1][2];
        }

        int max = Math.max(Math.max(max_dp[0][0], max_dp[0][1]), max_dp[0][2]);
        int min = Math.min(Math.min(min_dp[0][0], min_dp[0][1]), min_dp[0][2]);

        bw.write(max + " " + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
