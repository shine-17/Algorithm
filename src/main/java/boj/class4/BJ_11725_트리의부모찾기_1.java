package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class BJ_11725_트리의부모찾기_1 {
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

            findRoot(1);

            StringBuilder result = new StringBuilder();
            for (int i = 2; i< parentNodes.length; i++) {
                result.append(parentNodes[i]).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void findRoot(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer rootNode = queue.poll();

            for (Integer node : tree[rootNode]) {
                if (parentNodes[node] == 0) {
                    parentNodes[node] = rootNode;
                    findRoot(node);
                }
            }
        }

    }
}
