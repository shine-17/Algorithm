package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_5 {
    static int r, c;
    static int[][] alphabets;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static boolean[] visited = new boolean[26];
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

            visited[alphabets[0][0]] = true;
            dfs(0, 0, 1);

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void dfs(int x, int y, int len) {
        if (x > 0) {
            if (!visited[alphabets[x-1][y]]) {
                visited[alphabets[x-1][y]] = true;
                dfs(x-1, y, len+1);
                visited[alphabets[x-1][y]] = false;
            }
        }

        if (x < r-1) {
            if (!visited[alphabets[x+1][y]]) {
                visited[alphabets[x+1][y]] = true;
                dfs(x+1, y, len+1);
                visited[alphabets[x+1][y]] = false;
            }
        }

        if (y > 0) {
            if (!visited[alphabets[x][y-1]]) {
                visited[alphabets[x][y-1]] = true;
                dfs(x, y-1, len+1);
                visited[alphabets[x][y-1]] = false;
            }
        }

        if (y < c-1) {
            if (!visited[alphabets[x][y+1]]) {
                visited[alphabets[x][y+1]] = true;
                dfs(x, y+1, len+1);
                visited[alphabets[x][y+1]] = false;
            }
        }

        max = Math.max(max, len);
    }
}