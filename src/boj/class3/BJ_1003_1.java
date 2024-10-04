package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1003_1 {
    static int[] fib;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int t = Integer.parseInt(br.readLine());

            for(int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());
                fib = new int[n+1];

                System.out.println(fibonacci(n-1) + " " + fibonacci(n));
            }
        } catch(Exception ignored) {}
    }

    private static int fibonacci(int n) {
        if(n < 0) { // 호출한 쪽에서 n이 0일 때, -1로 들어옴 -> fibonacci(0)은 0이 1개, 1이 0개이기 때문에 return 1
            return 1;
        }
        else if(n <= 1) {
            fib[n] = n;
        }
        else if(fib[n] == 0) {
            fib[n] = fibonacci(n-1) + fibonacci(n-2);
        }

        return fib[n];
    }
}
