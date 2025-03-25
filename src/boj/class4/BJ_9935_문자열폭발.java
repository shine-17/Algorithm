package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_9935_문자열폭발 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String str = br.readLine();
            String bomb = br.readLine();

            int str_length = str.length();   // 문자열
            int bomb_length = bomb.length(); // 폭발문자열

            LinkedList<Character> stack = new LinkedList<>();

            for (int i=0; i<str_length; i++) {
                char ch = str.charAt(i);
                stack.add(ch);

                if (stack.size() >= bomb_length) {
                    int size = stack.size();

                    boolean isEquals = true;

                    for (int j=0; j<bomb_length; j++) {
                        if (stack.get(size - bomb_length + j) != bomb.charAt(j)) {
                            isEquals = false;
                            break;
                        }
                    }

                    if (isEquals) {
                        for (int j=0; j<bomb_length; j++) {
                            stack.pollLast();
                        }
                    }
                }
            }

            String result = stack.stream().map(String::valueOf).collect(Collectors.joining(""));
            System.out.println(result.isEmpty() ? "FRULA" : result);

        } catch (Exception ignored) {}
    }
}
