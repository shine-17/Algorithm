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

            // 0과 1은 모두 0번 연산하기 때문에 0 으로 초기화
            numArr[0] = numArr[1] = 0;

            System.out.println(operate(n));

        } catch(Exception ignored) {}
    }

    private static int operate(int n) {

        /*
            * DP 문제는 3가지 단계를 생각 *
                1. 테이블 정의
                2. 점화식 찾기
                3. 초기값 정하기


            1. n이 3으로 나누어 떨어지면, 3으로 나눈다.
            2. n이 2로 나누어 떨어지면, 2로 나눈다.
            3. 1을 뺀다.

            Q. n이 3과 2의 공배수이면?

            1. n이 6으로 나누어 떨어지면, 6으로 나눈다. -> 6으로 나눌 때 2,3,4번 중 어떤 연산이 최소연산일지 모르기 때문에 비교해야함
            2. n이 3으로 나누어 떨어지면, 3으로 나눈다.
            3. n이 2로 나누어 떨어지면, 2로 나눈다.
            4. 1을 뺀다.

            이렇게 바뀌어야한다.

            최소 연산 횟수를 구해야하기 때문에 재귀 호출한 값의 최소값을 비교해야함.

         */

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

            // 연산할 때마다 카운팅
            numArr[n]++;
        }

        return numArr[n];
    }
}
