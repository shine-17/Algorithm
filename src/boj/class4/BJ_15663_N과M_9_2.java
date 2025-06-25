package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15663_N과M_9_2 {
    static int m;
    static int[] arr;
    static int[] seqs;
    static boolean[] visited;

    static StringBuilder result = new StringBuilder();
    static HashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            seqs = new int[m];
            visited = new boolean[n];

            backTracking(0);

            result.setLength(0);
            for (String str : set) {
                result.append(str).append("\n");
            }

            System.out.print(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int depth) {
        if (depth == m) {
            result.setLength(0);
            Arrays.stream(seqs).forEach(num -> result.append(num).append(" "));
            set.add(result.toString());
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            seqs[depth] = arr[i];
            backTracking(depth+1);
            visited[i] = false;
        }
    }
}
