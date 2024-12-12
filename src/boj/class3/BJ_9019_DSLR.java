package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    D, S L, R을 이용하는 계산기

    0 <= n < 10000
    n의 네 자릿수는 d1, d2, d3, d4
    n = ((d1 * 10 + d2) * 10 + d3) * 10 +d4

    D: 2n % 10000 (2n이 9999보다 크면 10000으로 나눔)
    S: n-1 (n이 0일 때는 9999가 저장)
    L: n의 각 자릿수를 왼편으로 1번씩 회전 d1,d2,d3,d4 -> d2,d3,d4,d1
    R: n의 각 자릿수를 오른편으로 1번씩 회전 d1,d2,d3,d4 -> d4,d1,d2,d3
 */

public class BJ_9019_DSLR {

    static boolean[] visited = new boolean[10000];
    static String[] cmdArr = new String[10000];
    static Queue<Integer> cmdQ = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                bfs(a, b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bfs(int a, int b) {
        visited = new boolean[10000];
        cmdArr = new String[10000];
        cmdQ = new LinkedList<>();

        Arrays.fill(cmdArr, "");
        cmdQ.add(a);
        visited[a] = true;

        while(!cmdQ.isEmpty() && !visited[b]) {
            int n = cmdQ.poll();
            int d = cmdD(n);
            int s = cmdS(n);
            int l = cmdL(n);
            int r = cmdR(n);

            visit(n, d,'D');
            visit(n, s, 'S');
            visit(n, l, 'L');
            visit(n, r, 'R');
        }

        System.out.println(cmdArr[b]);
    }

    private static void visit(int n, int m, char cmd) {
        if(!visited[m]) {
            visited[m] = true;
            cmdQ.add(m);
            cmdArr[m] += cmdArr[n] + cmd;
        }
    }

    /**
     * D: 2n % 10000 (2n이 9999보다 크면 10000으로 나눔)
     */
    private static int cmdD(int a) {
        return a * 2 % 10000;
    }

    /**
     * S: n-1 (n이 0일 때는 9999가 저장)
     */
    private static int cmdS(int a) {
        return a <= 0 ? 9999 : a - 1;
    }

    /**
     * L: n의 각 자릿수를 왼편으로 1번씩 회전 d1,d2,d3,d4 -> d2,d3,d4,d1
     */
    private static int cmdL(int a) {
        return (a % 1000 * 10) + (a / 1000);
    }

    /**
     * R: n의 각 자릿수를 오른편으로 1번씩 회전 d1,d2,d3,d4 -> d4,d1,d2,d3
     */
    private static int cmdR(int a) {
        return (a % 10 * 1000) + (a / 10);
    }

}
