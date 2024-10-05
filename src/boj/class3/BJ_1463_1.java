package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1463_1 {
    static Integer[] numArr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            /*
                DP 문제는 3가지 단계를 생각
                1. 테이블 정의
                2. 점화식 찾기
                3. 초기값 정하기
             */

            int n = Integer.parseInt(br.readLine());

            numArr = new Integer[n+1];
            numArr[0] = numArr[1] = 0;

            System.out.println(operate(n));

        } catch(Exception ignored) {}
    }

    private static int operate(int n) {

        if(numArr[n] == null) {
            if(n % 6 == 0) {
                numArr[n] = Math.min(Math.min(operate(n / 3), operate(n / 2)), operate(n - 1));
            }
            else if(n % 3 == 0) {
                numArr[n] = Math.min(operate(n / 3), operate(n - 1));
            }
            else if(n % 2 == 0) {
                numArr[n] = Math.min(operate(n / 2), operate(n - 1));
            }
            else {
                numArr[n] = operate(n - 1);
            }

            numArr[n]++;
        }

        return numArr[n];
    }
}
