package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1012_유기농배추_1 {
    static int[][] fields;
    static boolean[][] visited;
    static Queue<int[]> cabbages;
    static int count;
    static final int[] fx = {-1, 0, 1, 0};
    static final int[] fy = {0, 1, 0, -1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        try {
            int t = Integer.parseInt(br.readLine());

            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
                int n = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
                int k = Integer.parseInt(st.nextToken()); // 배추의 개수
                fields = new int[n][m];
                visited = new boolean[n][m];
                cabbages = new LinkedList<>();
                count = 0;

                for(int j=0; j<k; j++) {
                    st = new StringTokenizer(br.readLine());

                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    fields[b][a] = 1;
                    cabbages.add(new int[]{a, b});
                }

                while(!cabbages.isEmpty()) {
                    int[] cabbage = cabbages.poll();
                    int x = cabbage[0];
                    int y = cabbage[1];

                    if(visited[y][x]) continue;

                    find(x, y);
                    count++;
                }

                sb.append(count).append("\n");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }

    private static void find(int m, int n) {
        visited[n][m] = true;

        for(int i=0; i<fx.length; i++) {
            int x = n + fy[i];
            int y = m + fx[i];

            if(x >= 0 && x < fields.length && y >= 0 && y < fields[0].length) {
                if(!visited[x][y] && fields[x][y] == 1) {
                    find(y, x);
                }
            }
        }
    }
}
