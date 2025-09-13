package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기_1 {
    static List<Integer> trees;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            trees = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                trees.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(trees);

            int result = find(0, trees.get(trees.size()-1), m);

            System.out.println(result);

        } catch(Exception ignored) {}
    }

    static int find(int start, int end, int m) {
        while(start < end) {
            int mid = (start + end) / 2;
            long sum = cutTree(mid);

            if(m > sum) end = mid;
            else start = mid + 1;
        }

        return start - 1;
    }

    static long cutTree(int length) {
        long sum = 0;

        for(Integer tree : trees) {
            if(tree > length) sum += (tree - length);
        }

        return sum;
    }
}
