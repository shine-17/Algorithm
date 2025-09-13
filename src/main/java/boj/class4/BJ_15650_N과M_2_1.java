package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15650_N과M_2_1 {
    static StringBuilder result = new StringBuilder();
    static List<Integer> seq = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            backTracking(1, n, m);

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int start, int n, int m) {
        if (seq.size() == m) {
            seq.forEach(num -> result.append(num).append(" "));
            result.append("\n");
            return;
        }

        for (int i=start; i<=n; i++) {
            seq.add(i);
            backTracking(i+1, n, m);
            seq.remove(seq.size()-1);
        }
    }

}
