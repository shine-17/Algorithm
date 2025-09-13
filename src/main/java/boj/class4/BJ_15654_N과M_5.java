package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class BJ_15654_N과M_5 {
    static int[] numbers;
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

            numbers = new int[n];
            arr = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[Arrays.stream(numbers).max().orElseThrow(NoSuchElementException::new) + 1];

            Arrays.sort(numbers);

            backTracking(0);

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void backTracking(int depth) {
        if (depth == m) {
            Arrays.stream(arr).forEach(num -> result.append(num).append(" "));
            result.append('\n');
            return;
        }

        for (Integer num : numbers) {
            if (!visited[num]) {
                visited[num] = true;
                arr[depth] = num;
                backTracking(depth+1);
                visited[num] = false;
            }
        }

    }
}
