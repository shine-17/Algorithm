package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9461_파도반수열 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                result.append(addRectangle(n)).append("\n");
            }

            System.out.println(result);

        } catch(Exception ignored) {}
    }

    static long addRectangle(int n) {
        if(n < 4) return 1;

        long[] recArr = new long[n+1];
        recArr[1] = 1;
        recArr[2] = 1;
        recArr[3] = 1;

        for(int i=4; i<=n; i++) {
            recArr[i] = recArr[i-2] + recArr[i-3];
        }

        return recArr[n];
    }
}
