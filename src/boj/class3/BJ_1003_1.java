package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1003_1 {
    static int[] fib;
    static int a, b;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int t = Integer.parseInt(br.readLine());

            for(int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());
                fib = new int[41];

                fibonacci(n);
            }
        } catch(Exception ignored) {}
    }

    private static int fibonacci(int n) {
        if(n == 0) {
            return fib[0] = 0;
        }
        else if(n == 1) {
            return fib[1] = 1;
        }
        else if(fib[n] != 0) return fib[n];
        else return fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
