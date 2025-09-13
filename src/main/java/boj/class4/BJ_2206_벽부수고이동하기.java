package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2206_벽부수고이동하기 {
    static int[][] map;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static final int START = 0, END = 0, INF = 1000001;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n-1 == START && m-1 == END) {
                System.out.println(1);
                return;
            }

            map = new int[n][m];

            for (int i=0; i<n; i++) {
                String[] split = br.readLine().split("");

                for (int j=0; j<m; j++) {
                    int value = Integer.parseInt(split[j]);
                    map[i][j] = value;
                }
            }

            // 1번만 수행해서 찾아야 함
            // 맵을 [2][N][M] 크기로 지정하셔서 벽을 부수지 않은 경우를 [0][N][M], 벽을 부순 경우를 [1][N][M]로 표현하면
            // 2*N*M 크기의 맵에 bfs를 한 번만 돌려서 문제를 푸실 수 있습니다

            System.out.println(move(n, m));

        } catch (Exception ignored) {}
    }

    static int move(int n, int m) {
        boolean[][][] visited = new boolean[2][n][m];
        int[][] dist = new int[n][m];

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, START, END));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i=0; i<mx.length; i++) {
                int nw = point.w; // 벽 부쉈는지 여부
                int nx = point.x + mx[i];
                int ny = point.y + my[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                    // 벽일 때
                    if (map[nx][ny] == 1) {
                        // 벽을 부신 적이 없고, 방문하지 않았을 때
                        if (nw == 0 && !visited[1][nx][ny]) {
                            visited[nw][nx][ny] = true;
                            dist[nx][ny] = dist[point.x][point.y] + 1;
                            queue.add(new Point(1, nx, ny));
                        }
                    }
                    // 벽이 아닐 때
                    else {
                        // 방문하지 않았을 때
                        if (!visited[nw][nx][ny]) {
                            visited[nw][nx][ny] = true;
                            dist[nx][ny] = dist[point.x][point.y] + 1;
                            queue.add(new Point(nw, nx, ny));
                        }

                    }

                    if (nx == n-1 && ny == m-1) {
                        return dist[nx][ny] + 1;
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int w; // 벽 부쉈는지 여부
        int x;
        int y;

        public Point(int w, int x, int y) {
            this.w = w;
            this.x = x;
            this.y = y;
        }
    }
}
