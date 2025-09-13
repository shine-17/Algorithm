package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15654_N과M_5_1 {
    static int[] arr;
    static List<Integer> seq = new ArrayList<>();
    static StringBuilder result = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n];
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);

            backTracking(n, m);

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int n, int m) {
        if (seq.size() == m) {
            seq.forEach(num -> result.append(num).append(" "));
            result.append("\n");
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (visited[i]) continue;

            seq.add(arr[i]);
            visited[i] = true;
            backTracking(n, m);
            visited[i] = false;
            seq.remove(seq.size()-1);
        }
    }
}
