package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노_1 {

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};
    static int[][] polyomino;
    static Point[] arr;
    static int n, m;
    static boolean[][] visited;
    static int max;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            polyomino  = new int[n][m];
            visited = new boolean[n][m];
            arr = new Point[4];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<m; j++) {
                    polyomino[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    visited[i][j] = true;
                    tetromino(i, j, 0);
                    visited[i][j] = false;
                }
            }

            System.out.println(max);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    // 0: 6, 1: 5, 2: 4,

    static void tetromino(int x, int y, int depth) {
        if(depth != 2 || !arr[depth-1].isBack) arr[depth] = new Point(x, y, polyomino[x][y]);

        // ㅏ ㅓ ㅗ ㅜ
        if (depth == 2 && !arr[depth-1].isBack) {
            // ㅡ ㄱ
            arr[depth-1].isBack = true;
            tetromino(arr[depth - 1].x, arr[depth - 1].y, depth);
        }
        else if (depth == 3) {
            final int[] sum = new int[1];
            Arrays.stream(arr).iterator().forEachRemaining(point -> sum[0] += point.num);
            max = Math.max(max, sum[0]);
            return;
        }

        for(int i=0; i<mx.length; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    tetromino(nx, ny, depth + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int num;
        boolean isBack;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
