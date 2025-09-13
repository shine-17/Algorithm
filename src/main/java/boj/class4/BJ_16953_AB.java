package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16953_AB {
    static int max;
    static Map<Integer, Integer> numMap;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            max = Math.max(a, b) + 1;
            numMap = new HashMap<>();

            Integer num = bfs(a, b);
            int result =  num == null ? -1 : ++num;
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static Integer bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            if (num == b) break;

            // 2를 곱한다.
            if (num * 2 < max) {
                int newNum = num * 2;
                queue.add(newNum);
                numMap.put(newNum, numMap.getOrDefault(num, 0) + 1);
            }

            // 1을 수의 가장 오른쪽에 추가한다.
            if (Long.parseLong(num + "1") < max) {
                int newNum = Integer.parseInt(num + "1");
                queue.add(newNum);
                numMap.put(newNum, numMap.getOrDefault(num, 0) + 1);
            }
        }

        return numMap.get(b);
    }
}
