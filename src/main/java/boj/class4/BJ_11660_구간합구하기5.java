package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            long[][] sumArr = new long[n+1][n+1];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sumArr[i+1][j+1] = arr[i][j] + sumArr[i+1][j] + sumArr[i][j+1] - sumArr[i][j];
                }
            }

//            StringBuilder sb = new StringBuilder();
//            for (long[] arrs : sumArr) {
//                for (Long num : arrs) {
//                    sb.append(num).append(" ");
//                }
//                sb.append("\n");
//            }
//            System.out.println(sb);

            StringBuilder result = new StringBuilder();

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                long sum = 0;

                sum += sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];

                result.append(sum).append("\n");
            }

            System.out.println(result);


        } catch (Exception ignored) {}
    }
}
