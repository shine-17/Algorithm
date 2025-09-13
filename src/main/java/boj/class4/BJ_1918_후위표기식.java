package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_1918_후위표기식 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String infix = br.readLine();

            System.out.println(convertInfixToPostfix(infix));

        } catch (Exception ignored) {}
    }

    static String convertInfixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();

        ArrayDeque<Character> queue = new ArrayDeque<>(Arrays.stream(infix.split("")).map(s -> s.charAt(0)).collect(Collectors.toList()));
        ArrayDeque<Character> stack = new ArrayDeque<>();

            /*
                우선순위
                1. ( )
                2. * /
                3. + -

                (A+(B*C))-(D/E)
                (A+BC*)-DE/
                ABC*+DE/-

                A+B*C-D/E
                A+BC*-DE/
                ABC*+DE/-
             */

        while (!queue.isEmpty()) {
            Character node = queue.poll();

            List<Character> pushList = List.of('*', '/');
            List<Character> popList = List.of('+', '-');
            List<Character> popList2 = List.of(')');

            if (node == '(') {
                stack.add(node);
            }
            else if (pushList.contains(node)) {
                while (!stack.isEmpty()) {
                    if (stack.peekLast() == '(' || popList.contains(stack.peekLast())) break;

                    postfix.append(stack.pollLast());
                }

                stack.add(node);
            }
            else if (popList.contains(node)) {
                while (!stack.isEmpty()) {
                    Character pop = stack.peekLast();

                    if (pop == '(') break;

                    postfix.append(stack.pollLast());
                }

                stack.add(node);
            }
            else if (popList2.contains(node)) {
                while (!stack.isEmpty()) {
                    Character pop = stack.pollLast();

                    if (pop == '(') break;

                    postfix.append(pop);
                }
            }
            else {
                postfix.append(node);
            }
        }

        // 남아 있는 stack 모두 담기
        while (!stack.isEmpty()) {
            postfix.append(stack.pollLast());
        }

        return postfix.toString();
    }
}
