package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15649_N과M_1 {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new int[m];
            visited = new boolean[n];

            numberSequence(n, m, 0);

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    // 백트래킹 (재귀)
    static void numberSequence(int n, int m, int depth) {

        if (depth == m) {
            Arrays.stream(arr).forEach(i -> result.append(i).append(" "));
            result.append('\n');
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                numberSequence(n, m, depth + 1);
                visited[i] = false;

                /*
                    1234
                    1243
                    1324
                    ...

                    visited[i]를 true로 만든 후 false로 다시 만드는 이유

                    중복제거를 위해 자기 자신만 visited[i] = true로 설정한 후 백트래킹을 진행하며
                    백트래킹 종료 후에는 false로 설정하여 다른 백트래킹 로직에 포함될 수 있게함.

                 */
            }
        }


    }

}
