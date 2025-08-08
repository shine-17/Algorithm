package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_9935_문자열폭발_1 {
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

            ArrayList<Character> stack = new ArrayList<>();

            loop: for (int i=0; i<strLength; i++) {
                stack.add(str.charAt(i));

                int size = stack.size();

                if (size >= bombLength) {
                    int start = size - bombLength;

                    for (int j=0; j<bombLength; j++) {
                        if (stack.get(start+j) != bomb.charAt(j)) continue loop;
                    }

                    for (int j=0; j<bombLength; j++) {
                        stack.remove(stack.size()-1);
                    }
                }
            }

            StringBuilder result = new StringBuilder();

            if (stack.isEmpty()) result.append("FRULA");
            else stack.forEach(result::append);

            System.out.println(result);

        } catch (Exception ignored) {}
    }
}
