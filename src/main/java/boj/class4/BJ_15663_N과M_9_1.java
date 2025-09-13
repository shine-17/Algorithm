package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15663_N과M_9_1 {
    static int m;
    static int[] arr;
    static boolean[] visited;

    static List<Integer> list = new ArrayList<>();
    static HashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            visited = new boolean[n+1];

            backTracking();

            StringBuilder result = new StringBuilder();
            for (String str : set) {
                result.append(str).append("\n");
            }

            System.out.print(result);

        } catch (Exception ignored) {}
    }

    static void backTracking() {
        if (list.size() == m) {
            String str = String.join(" ", list.stream().map(String::valueOf).toArray(String[]::new));
            set.add(str);
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(arr[i]);
            backTracking();
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
