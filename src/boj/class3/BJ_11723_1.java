package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_11723_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            // 공집합 S
            Set<Integer> set = new HashSet<>();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();

                // all이나 empty 연산은 값이 안 들어오기 때문에 예외처리 필요
                int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

                switch (op) {
                    case "add":
                        // S에 x 추가
                        set.add(value);
                        break;
                    case "remove":
                        // S에서 x 제거
                        set.remove(value);
                        break;
                    case "check":
                        // S에 x가 있으면 1을, 없으면 0을 출력 (삼항 연산자)
                        sb.append(set.contains(value) ? 1 : 0).append("\n");
                        break;
                    case "toggle":
                        // S에 x가 있으면 x를 제거
                        if(set.contains(value)) set.remove(value);
                        // S에 x가 없으면 x를 추가
                        else set.add(value);
                        break;
                    case "all":
                        // S를 초기화
                        set.clear();
                        // 반복문을 통해 S에 {1, 2, ..., 20} 추가
                        for(int j=1; j<=20; j++) {
                            set.add(j);
                        }
                        break;
                    case "empty":
                        // S를 초기화
                        set.clear();
                        break;
                }
            }

            System.out.println(sb);

        } catch(Exception e) {}
    }
}
