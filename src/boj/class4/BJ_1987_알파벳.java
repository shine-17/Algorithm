package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1987_알파벳 {
    static int r, c;
    static char[][] alphabets;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            alphabets = new char[r][c];

            for (int i=0; i<r; i++) {
                alphabets[i] = br.readLine().toCharArray();
            }

            // dfs, backTracking
            Set<Character> visited = new HashSet<>();
            visited.add(alphabets[0][0]);
            dfs(0, 0, visited);

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void dfs(int rx, int cy, Set<Character> visited) {
        max = Math.max(max, visited.size());

        for (int i=0; i<dx.length; i++) {
            int nx = rx + dx[i];
            int ny = cy + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited.contains(alphabets[nx][ny])) {
                visited.add(alphabets[nx][ny]);
                dfs(nx, ny, visited);
                visited.remove(alphabets[nx][ny]);
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
