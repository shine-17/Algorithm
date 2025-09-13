package boj.class3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14940_쉬운최단거리 {
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            distance = new int[n][m];
            visited = new boolean[n][m];

            Point start = null; // 목표지점 (2인 곳)
            for(int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");

                for(int j=0; j<m; j++) {
                    int num = Integer.parseInt(split[j]);
                    map[i][j] = num;

                    if(num == 2) start = new Point(i, j);
                }
            }

            if(start == null) return;

            findPath(start);

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    int num = map[i][j] == 1 && distance[i][j] == 0 ? -1 : distance[i][j];
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }

    static void findPath(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i=0; i<mx.length; i++) {
                int nx = point.x + mx[i];
                int ny = point.y + my[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && distance[nx][ny] == 0) {
                    if(map[nx][ny] == 0) continue;

                    queue.add(new Point(nx, ny));
                    distance[nx][ny] = distance[point.x][point.y] + 1;
                }
            }
        }

        // 목표지점 0 초기화
        distance[start.x][start.y] = 0;
    }

    static private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
