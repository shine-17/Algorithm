package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ_15663_N과M_9 {
    static int[] arr;
    static int[] sequences;
    static boolean[] visited;
    static int n, m;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[m];
            sequences = new int[n];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                sequences[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sequences);

            backTracking(0);

            result.setLength(0);
            for (String seq : set) {
                result.append(seq).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int depth) {
        if (depth == m) {
            result.setLength(0);
            Arrays.stream(arr).forEach(num -> result.append(num).append(" "));
            set.add(result.toString());
            return;
        }

        for (int i=0; i<sequences.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = sequences[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
