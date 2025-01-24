package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2096_내려가기_1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[] max_dp = new int[3];
        int[] min_dp = new int[3];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max_dp[0] = min_dp[0] = a;
                max_dp[1] = min_dp[1] = b;
                max_dp[2] = min_dp[2] = c;
            }
            else {
                int maxBefore0 = max_dp[0];
                int maxBefore2 = max_dp[2];
                max_dp[0] = Math.max(max_dp[0], max_dp[1]) + a;
                max_dp[2] = Math.max(max_dp[1], max_dp[2]) + c;
                max_dp[1] = Math.max(Math.max(maxBefore0, max_dp[1]), maxBefore2) + b;

                int minBefore0 = min_dp[0];
                int minBefore2 = min_dp[2];
                min_dp[0] = Math.min(min_dp[0], min_dp[1]) + a;
                min_dp[2] = Math.min(min_dp[1], min_dp[2]) + c;
                min_dp[1] = Math.min(Math.min(minBefore0, min_dp[1]), minBefore2) + b;
            }
        }

//            int max = Arrays.stream(max_dp).max().getAsInt();
//            int min = Arrays.stream(min_dp).min().getAsInt();

        // 4,194,304 byte = 4MB
//            Runtime.getRuntime().gc();
//            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//            System.out.print(usedMemory + " bytes");

        bw.write(Math.max(Math.max(max_dp[0], max_dp[1]), max_dp[2]) + " ");
        bw.write(Math.min(Math.max(min_dp[0], min_dp[1]), min_dp[2]) + "\n");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();

    }
}
