package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_4 {
    static int r, c;
    static int[][] alphabets;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static boolean[] visited = new boolean[26]; // 알파벳 배열 a-z
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            alphabets = new int[r][c];

            for (int i=0; i<r; i++) {
                char[] charArray = br.readLine().toCharArray();

                for (int j=0; j<c; j++) {
                    alphabets[i][j] = charArray[j] - 'A';
                }
            }

            dfs(0, 0, 1);


            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void dfs(int x, int y, int len) {
        visited[alphabets[x][y]] = true;
        max = Math.max(max, len);

        if (max == 26) return;

        for (int i=0; i<mx.length; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!visited[alphabets[nx][ny]]) {
                    visited[alphabets[nx][ny]] = true;
                    dfs(nx, ny, len + 1);
                    visited[alphabets[nx][ny]] = false;
                }
            }
        }
    }
}