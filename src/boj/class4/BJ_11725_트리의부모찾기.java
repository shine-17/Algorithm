package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// dfs
public class BJ_11725_트리의부모찾기 {
    static ArrayList<Integer>[] tree;
    static int[] parentNodes;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            tree = new ArrayList[n+1];
            parentNodes = new int[n+1];

            for (int i=0; i<tree.length; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (!tree[a].contains(b)) tree[a].add(b);
                if (!tree[b].contains(a)) tree[b].add(a);
            }

            // dfs
            findRoot(1);

            StringBuilder result = new StringBuilder();
            for (int i = 2; i< parentNodes.length; i++) {
                result.append(parentNodes[i]).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void findRoot(int root) {
        for (Integer num : tree[root]) {
            if (parentNodes[num] == 0) {
                parentNodes[num] = root;
                findRoot(num);
            }
        }
    }
}
