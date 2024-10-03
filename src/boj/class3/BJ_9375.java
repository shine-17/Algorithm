package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_9375 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());
                Map<String, Integer> map = new HashMap<>();

                for (int j = 0; j < n; j++) {
                    String costume = br.readLine().split(" ")[1];
                    map.put(costume, map.getOrDefault(costume, 0) + 1);
                }

                int result = 1;
                for (int value : map.values()) {
                    result *= (value + 1);
                }

                System.out.println(result - 1);
            }

/*
    [조합문제]
    1. 안 입는 것까지 포함 (안 입는 것은 null로 표현)
    2. 알몸이 아닌상태라고 했으니 전부 안 입는 것 제외 (연산 후 -1 해야함)

    headgear - hat, turban, null
    eyewear - sunglasses, null
    top - shirt, knit, null

    조합 공식 : nCr = n! / r!(n-r)!
    n은 종류, r은 선택개수

    ex) headgear 중 1개만 선택해야하는 조합의 수는 3c1

    3c1 = 3 * 2 / 2 * 1 = 3
    2c1 = 2 / 1 = 2

    = 3c1 * 2c1 - 1 = 5


 */
        } catch (Exception ignored) {}
    }
}
