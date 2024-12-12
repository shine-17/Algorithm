package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9019_DSLR_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        /*
            D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
            S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
            L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
            R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
         */

        try {

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                result.append(command(a, b)).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static String command(int a, int b) {
        String[] cmd = new String[10001];
        cmd[a] = "";

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while(!queue.isEmpty() || cmd[b] == null) {
            int num = queue.poll();

            int d = commandD(num);
            if(cmd[d] == null) {
                cmd[d] = cmd[num] + "D";
                queue.add(d);
            }

            int s = commandS(num);
            if(cmd[s] == null) {
                cmd[s] = cmd[num] + "S";
                queue.add(s);
            }

            int l = commandL(num);
            if(cmd[l] == null) {
                cmd[l] = cmd[num] + "L";
                queue.add(l);
//                System.out.println("cmd[" + l + "] : " + cmd[l]);
            }

            int r = commandR(num);
            if(cmd[r] == null) {
                cmd[r] = cmd[num] + "R";
                queue.add(r);
            }
        }

        return cmd[b];
    }

    static int commandD(int n) {
        return n * 2 % 10000;
    }

    static int commandS(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    static int commandL(int n) {
//        String str = String.valueOf(n);
//        if(str.length() < 4) str = "0".repeat(4 - str.length()) + str;
//        return Integer.parseInt(str.substring(1) + str.charAt(0));

        return (n % 1000 * 10) + (n / 1000);

//        List<String> list = Arrays.asList(String.valueOf(n).split(""));
//        Queue<String> queue = new LinkedList<>(list);
//
//        String poll = queue.poll();
//        queue.add(poll);
//
//        StringBuilder result = new StringBuilder();
//        queue.forEach(result::append);
//        return Integer.parseInt(result.toString());
    }

    static int commandR(int n) {
//        String str = String.valueOf(n);
//        if(str.length() < 4) str = "0".repeat(4 - str.length()) + str;
//        return Integer.parseInt(str.charAt(str.length() - 1) + str.substring(0, str.length() - 1));

        return (n % 10 * 1000) + (n / 10);


//        List<String> list = Arrays.asList(String.valueOf(n).split(""));
//        Deque<String> queue = new LinkedList<>(list);
//
//        String poll = queue.pollLast();
//        queue.addFirst(poll);
//
//        StringBuilder result = new StringBuilder();
//        queue.forEach(result::append);
//        return Integer.parseInt(result.toString());
    }
}
