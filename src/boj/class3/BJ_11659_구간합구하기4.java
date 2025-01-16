package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] arr = new long[n+1];    // 입력받은 배열
            long[] sumArr = new long[n+1]; // 누적합 배열

            int index = 1;
            while(st.hasMoreTokens()) {
                arr[index] = Long.parseLong(st.nextToken());
                sumArr[index] = arr[index] + sumArr[index-1];

                index++;
            }

            StringBuilder result = new StringBuilder();
            for(int k=0; k<m; k++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                long sum = sumArr[j] - sumArr[i-1];
                result.append(sum).append("\n");
            }

            System.out.println(result);

        } catch(Exception ignored) {}
    }
}
