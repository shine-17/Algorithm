package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_곱셈 {
    static int c;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            System.out.println(pow(a, b));

        } catch (Exception ignored) {}
    }

    /*
        a: 10
        b: 11
        c: 12

        10^11 % 12 =>

            (10^11) % 12 -> (10 % 12) * (10 % 12) ... x11

            10^11 % 12 = (10 % 12) * (10 % 12) ... x11

            10^3 % 12 = (10 % 12) * (10 % 12) * (10 % 12) =
     */

    static long pow(int a, int b) {
        if (b == 1) return a % c;

        long powNum = pow(a, b / 2);

        if (b % 2 == 1) {
            return (powNum * powNum % c) * a % c;
        }

        return powNum * powNum % c;
    }
}
