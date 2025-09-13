package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_곱셈_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int result = multiple(a, b, c);
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    public static int multiple(int a, int b, int c) {
        if (b == 1) return a % c;

        /*
            a: 10
            b: 11
            c: 12

            10^11 % 12 =>
            (10^11) % 12 -> (10 % 12) * (10 % 12) ... x11
            10^11 % 12 = (10 % 12) * (10 % 12) ... x11
            10^3 % 12 = (10 % 12) * (10 % 12) * (10 % 12) =
         */

        int powNum = multiple(a, b / 2, c);

        if (b % 2 == 1) {
            powNum = (powNum * powNum % c) * (a % c);
        }

        return powNum * powNum % c;
    }

}
