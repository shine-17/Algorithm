package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15652_N과M_4 {
    static int[] arr;
    static boolean[] visited;
    static int n, m;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[m];
            visited = new boolean[n+1];

            backTracking(1, 0);

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int at, int depth) {
        if (depth == m) {
            Arrays.stream(arr).forEach(num -> result.append(num).append(" "));
            result.append('\n');
            return;
        }

        for (int i=at; i<=n; i++) {
            arr[depth] = i;
            backTracking(i, depth+1);
        }
    }

}
