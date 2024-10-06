package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9095_1 {
    static int[] sumArr = new int[11];

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int t = Integer.parseInt(br.readLine());
            sumArr[1] = 1;
            sumArr[2] = 2;
            sumArr[3] = 4;

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());

                int count = plus(n);
                sb.append(count).append("\n");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }

    /*
        n=1

        1
        --------------------------------
        n=2

        1+1
        2
        --------------------------------
        n=3

        1+1+1
        1+2
        2+1
        3
        --------------------------------
        n=4
        1+1+1+1
        1+2+1
        2+1+1
        3+1
        ------> n=3일 때와 개수동일

        1+1+2
        2+2
        ------> n=2일 때와 개수동일

        1+3
        ------> n=1일 때와 개수동일
        --------------------------------

        점화식
        f(n) = f(n-1) + f(n-2) + f(n-3)

     */

    static int plus(int n) {
        if(sumArr[n] == 0) {
            sumArr[n] = plus(n-1) + plus(n-2) + plus(n-3);
        }

        return sumArr[n];
    }
}
