package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9935_문자열폭발_2 {
    static String str;
    static String bomb;
    static int strLength;
    static int bombLength;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            str = br.readLine();
            bomb = br.readLine();
            strLength = str.length();
            bombLength = bomb.length();

            StringBuilder stack = new StringBuilder();

            loop: for (int i=0; i<strLength; i++) {
                stack.append(str.charAt(i));

                int size = stack.length();

                if (size >= bombLength) {
                    int start = size - bombLength;

                    for (int j=0; j<bombLength; j++) {
                        if (stack.charAt(start+j) != bomb.charAt(j)) continue loop;
                    }

                    for (int j=0; j<bombLength; j++) {
                        stack.deleteCharAt(stack.length()-1);
                    }
                }
            }

            if (stack.isEmpty()) System.out.println("FRULA");
            else System.out.println(stack);

        } catch (Exception ignored) {}
    }
}