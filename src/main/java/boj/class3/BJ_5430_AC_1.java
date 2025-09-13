package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5430_AC_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {

                try {
                    String[] p = br.readLine().split(""); // 함수
                    int n = Integer.parseInt(br.readLine());

                    String arrInput = br.readLine().replaceAll("[\\[|\\]]", "");
                    String[] split = !arrInput.trim().isEmpty() ? arrInput.split(",") : new String[0];

                    Deque<String> deque = new ArrayDeque<>();
                    boolean isReverse = false;

                    for(String str : split) {
                        deque.addLast(str);
                    }

                    // 함수 수행
                    for(String fn : p) {
                        if(fn.equals("D")) {
                            if(deque.isEmpty()) throw new Exception();

                            if(isReverse) deque.pollLast();
                            else deque.pollFirst();
                        }
                        else {
                            isReverse = !isReverse;
                        }
                    }

                    List<String> list = new ArrayList<>(deque);
                    if(isReverse) Collections.reverse(list);
                    sb.append(list.toString().replaceAll(" ", "")).append("\n");

                } catch (Exception e) {
                    sb.append("error").append('\n');
                }
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }
}