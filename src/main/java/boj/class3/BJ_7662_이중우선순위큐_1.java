package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7662_이중우선순위큐_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        try {

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                int k = Integer.parseInt(br.readLine());
                TreeMap<Integer, Integer> pq = new TreeMap<>();

                for(int j=0; j<k; j++) {
                    // 연산 : D: 삭제(1: 최댓값 삭제, -1: 최솟값 삭제 / 하나만 삭제), I: 삽입
                    st = new StringTokenizer(br.readLine());

                    String op = st.nextToken();
                    int num = Integer.parseInt(st.nextToken());

                    // 삽입
                    if(op.equals("I")) {
                        pq.put(num, pq.getOrDefault(num, 0) + 1);
                    }
                    // 삭제
                    else {
                        if(pq.isEmpty()) continue;

                        int key = num == 1 ? pq.lastEntry().getKey() : pq.firstEntry().getKey();

                        if(pq.get(key) == 1) pq.remove(key);
                        else pq.put(key, pq.get(key) - 1);
                    }
                }

                if(pq.isEmpty()) {
                    sb.append("EMPTY").append("\n");
                }
                else {
                    sb.append(pq.lastKey()).append(" ").append(pq.firstKey()).append("\n");
                }
            }

            System.out.println(sb);

        } catch (Exception ignored) {}
    }
}
