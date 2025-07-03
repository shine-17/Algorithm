package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_1 {
    static int[][] sumArr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n+1][n+1];
            sumArr = new int[n][n];

            for (int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j=1; j<=n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cumulativeSum(arr);

            StringBuilder result = new StringBuilder();
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                int sum = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];
                result.append(sum).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void cumulativeSum(int[][] arr) {
        for (int i=1; i<arr.length; i++) {
            for (int j=1; j<arr[i].length; j++) {
                arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
    }
}
