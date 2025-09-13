package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ_15666_N과M_12 {
    static int[] arr;
    static int[] sequences;
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

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                sequences[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sequences);

            backTracking(0, 0);

            result.setLength(0);
            for (String seq : set) {
                result.append(seq).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int at, int depth) {
        if (depth == m) {
            result.setLength(0);
            Arrays.stream(arr).forEach(num -> result.append(num).append(" "));
            set.add(result.toString());
            return;
        }

        for (int i=at; i<sequences.length; i++) {
            arr[depth] = sequences[i];
            backTracking(i, depth + 1);
        }
    }
}
