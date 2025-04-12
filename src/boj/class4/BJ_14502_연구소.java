package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

// 완전 탐색 & 백트래킹 & 너비 우선 탐색
public class BJ_14502_연구소 {
    static int[][] map;
    static boolean[][] visited;

    static final int WALL_SIZE = 3; // 벽 세워야 하는 개수

    static final int SAFE = 0;      // 안전 구역(빈 칸)
    static final int SAFE_WALL = 3; // 빈 칸에서 벽 세운 곳
    static final int VIRUS = 4;     // 바이러스 전파된 곳

    static int n, m, max = Integer.MIN_VALUE;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};
    static ArrayDeque<Point> points = new ArrayDeque<>();

    static List<Point> virus = new ArrayList<>();
    static List<Point> rollback = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];

            // 0: 빈칸, 1: 벽, 2: 바이러스
            for (int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");

                for (int j=0; j<m; j++) {
                    int value = Integer.parseInt(split[j]);
                    map[i][j] = value;

                    if (value == 2) virus.add(new Point(i, j));
                }
            }

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (map[i][j] == 0) {
                        points.add(new Point(i, j));
                        visited[i][j] = true;

                        block(i, j);

                        visited[i][j] = false;
                        points.pollLast();
                    }
                }
            }

            System.out.println(max);

        } catch (Exception ignored) {}
    }
    static void block(int x, int y) {
        if (points.size() == WALL_SIZE) {
            setSafeZone(); // 벽 설치
            spreadVirus(); // 바이러스 확산
            max = Math.max(countSafeZone(), max); // 안전 영역 개수 구하기
            rollBack(); // 롤백 (벽 설치, 바이러스 확산)
            return;
        }

        for (int i=x; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    points.add(new Point(i, j));
                    visited[i][j] = true;

                    block(i, j);

                    visited[i][j] = false;
                    points.pollLast();
                }
            }
        }
    }

    static void setSafeZone() {
        for (Point point : points) {
            map[point.x][point.y] = SAFE_WALL;
        }
        rollback.addAll(points);
    }

    static void spreadVirus() {
        Queue<Point> queue = new ArrayDeque<>(virus);
        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (!visited[point.x][point.y]) {
                visited[point.x][point.y] = true;

                for (int i=0; i<mx.length; i++) {
                    int nx = point.x + mx[i];
                    int ny = point.y + my[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                        map[nx][ny] = VIRUS; // 확산된 바이러스

                        Point newPoint = new Point(nx, ny);
                        queue.add(newPoint);
                        rollback.add(newPoint);
                    }
                }
            }
        }
    }

    static int countSafeZone() {
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == SAFE) count++;
            }
        }

        return count;
    }

    static void rollBack() {
        for (Point point : rollback) {
            map[point.x][point.y] = SAFE;
        }
        rollback.clear();
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