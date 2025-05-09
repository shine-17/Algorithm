package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2206_벽부수고이동하기 {
    static int[][] map;
    static List<Point> walls = new ArrayList<>();
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static final int START = 1, END = 1, INF = 1000001;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new int[n+1][m+1];

            for (int i=1; i<=n; i++) {
//                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
                String[] split = br.readLine().split("");

                for (int j=1; j<=m; j++) {
                    int value = Integer.parseInt(split[j-1]);
                    map[i][j] = value;

                    if (value == 1) walls.add(new Point(i, j));
                }
            }

            TreeSet<Integer> set = new TreeSet<>();
//            set.add(move(n, m));

            // 1번만 수행해서 찾아야 함
            // 맵을 [2][N][M] 크기로 지정하셔서 벽을 부수지 않은 경우를 [0][N][M], 벽을 부순 경우를 [1][N][M]로 표현하면
            // 2*N*M 크기의 맵에 bfs를 한 번만 돌려서 문제를 푸실 수 있습니다

            move(n, m);

//            for (Point point : walls) {
//                map[point.x][point.y] = 0;
////                set.add(move(n, m));
//                move(n, m);
//                map[point.x][point.y] = 1;
//            }

//            System.out.println(set.higher(0) == null ? -1 : set.higher(0));
            System.out.println(min == INF ? -1 : min);


        } catch (Exception ignored) {}
    }

    static void move(int n, int m) {
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] dist = new int[n+1][m+1];

        dist[START][END] = 1;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(START, END));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (dist[n][m] != 0 || dist[n][m] > min) break;

            if (!visited[point.x][point.y]) {
                visited[point.x][point.y] = true;

//                System.out.println("x: " + point.x + ", y: " + point.y + ", dist: " + dist[point.x][point.y]);

                for (int i=0; i<mx.length; i++) {
                    int nx = point.x + mx[i];
                    int ny = point.y + my[i];

                    if (nx > 0 && ny > 0 && nx <= n && ny <= m && map[nx][ny] == 0) {
                        dist[nx][ny] = dist[point.x][point.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        min = Math.min(min, dist[n][m] == 0 ? INF : dist[n][m]);
//        return dist[n][m];
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
