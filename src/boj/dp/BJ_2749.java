package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2749 {

    static long[] fibo;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            long n = Long.parseLong(br.readLine());

            int m = 1000000;
            int p = 15 * 100000;

            fibo = new long[p+1];
            fibo[0] = 0;
            fibo[1] = 1;

            for(int i=2; i<n%p+1; i++) {
                fibo[i] = (fibo[i-1] + fibo[i-2]) % m;
            }

            int num = (int) (n%p);
            System.out.println(fibo[num]);

        } catch (Exception e) {}
    }
}
