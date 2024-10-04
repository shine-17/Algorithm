package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1463_1 {
    static Integer[] numArr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            numArr = new Integer[n+1];
            numArr[0] = numArr[1] = 0;

            System.out.println(operate(n));

        } catch(Exception ignored) {}
    }

    private static int operate(int n) {

        if(numArr[n] == null) {
            if(n % 6 == 0) {
                numArr[n] = Math.min(Math.min(operate(n / 3), operate(n / 2)), operate(n - 1)) + 1;
            }
            else if(n % 3 == 0) {
                numArr[n] = Math.min(operate(n / 3), operate(n - 1)) + 1;
            }
            else if(n % 2 == 0) {
                numArr[n] = Math.min(operate(n / 2), operate(n - 1)) + 1;
            }
            else {
                numArr[n] = operate(n - 1) + 1;
            }
        }

//        System.out.println("[" + n + "] " + numArr[n]);

        return numArr[n];
    }
}
