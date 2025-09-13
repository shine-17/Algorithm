package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2638_치즈 {
    static int[][] papers;
    static final int CONTACT_SIDE_COUNT = 2;        // 외부공기와 접촉해야 하는 변 개수
    static final int OUTSIDE_AIR = 2;               // 외부공기
    static Queue<Point> cheeses = new ArrayDeque<>();
    static Point corner = new Point(0, 0);   // 문제에 따로 조건이 없어서 치즈가 가운데에 있을 것이라고 생각해서 0,0 으로 시작점 잡음

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            papers = new int[n][m];

            for (int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");
                for (int j=0; j<split.length; j++) {
                    int value = Integer.parseInt(split[j]);
                    papers[i][j] = value;

                    if (value == 1) cheeses.add(new Point(i, j));
                }
            }


            int count = 0;
            while (!cheeses.isEmpty()) {
                floodFill();  // 외부공기 모두 2로 변경
                meltCheese(); // 외부공기와 2개의 변 이상 접촉된 치즈는 녹이기
                count++;
            }

            System.out.println(count);

        } catch (Exception ignored) {}
    }

    static void meltCheese() {
        cheeses.removeIf(cheese -> {
            if (isContactAir(cheese.x, cheese.y)) papers[cheese.x][cheese.y] = 0;   // 녹인 치즈는 0으로 변경
            return isContactAir(cheese.x, cheese.y);                                // 외부공기와 2변이상 접촉된 치즈는 큐에서 삭제
        });
    }

    static void floodFill() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(corner);

        boolean[][] visited = new boolean[papers.length][papers[0].length];

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (visited[point.x][point.y]) continue;

            visited[point.x][point.y] = true;

            for (int i=0; i<mx.length; i++) {
                int nx = point.x + mx[i];
                int ny = point.y + my[i];

                if (nx >= 0 && ny >= 0 && nx < papers.length && ny < papers[nx].length && (papers[nx][ny] == 0 || papers[nx][ny] == 2)) {
                    papers[nx][ny] = OUTSIDE_AIR;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    static boolean isContactAir(int x, int y) {
        int count = 0;

        for (int i=0; i<mx.length; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx >= 0 && ny >= 0 && nx < papers.length && ny < papers[nx].length && papers[nx][ny] == OUTSIDE_AIR) count++;
        }

        return count >= CONTACT_SIDE_COUNT;
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
