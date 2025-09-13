package boj.sliding_window;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_21921_블로그 {
    static int[] visit;
    static TreeMap<Integer, Integer> visitMap = new TreeMap<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            visit = new int[n+1];

            visit[1] = arr[0];
            for (int i=1; i<arr.length; i++) {
                visit[i+1] = visit[i] + arr[i];
            }

//            Arrays.stream(visit).forEach(num -> System.out.print(num + " "));
//            System.out.println();

            for (int i=x; i<visit.length; i++) {
                int sum = visit[i] - visit[i-x];

//                for (int j=i; j<i+x; j++) {
//                    sum += visit[j];
//                }

                visitMap.put(sum, visitMap.getOrDefault(sum, 0)+1);
            }

            if (visitMap.lastKey() == 0) result.append("SAD");
            else {
                result.append(visitMap.lastKey()).append("\n").append(visitMap.get(visitMap.lastKey()));
            }

            System.out.println(result);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
