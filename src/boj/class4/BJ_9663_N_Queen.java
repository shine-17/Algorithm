package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_9663_N_Queen {
    static int[][] chess;
    static int n;
    static int count;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            n = Integer.parseInt(br.readLine());
            chess = new int[n][n];

            /*
                0: 아무것도 없음
                1: 1 depth Queen
                2: 2 depth Queen
                ...

             */

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
//                    if (!isEnoughQueenPoint()) continue;
                    updateQueenPoint(i, j, 1);
                    findQueenPoint(i, j, 1);
                    rollbackQueenPoint(i, j, 1);
                }
            }

//            int a = 0;
//            int b = 1;
//            updateQueenPoint(a, b, 1);
//            findQueenPoint(a, b, 1);
//            rollbackQueenPoint(a, b, 1);

//            updateQueenPoint(0, 2, 1);
//            for (int i=0; i<n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(chess[i][j] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(count);

        } catch (Exception ignored) {}
    }

    static void findQueenPoint(int x, int y, int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i=x; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (chess[i][j] == 0) {
//                    if (!isEnoughQueenPoint()) continue;
                    updateQueenPoint(i, j, depth + 1);
                    findQueenPoint(i, j, depth + 1);
                    rollbackQueenPoint(i, j, depth + 1);
                }
            }
        }
    }

    static void updateQueenPoint(int x, int y, int depth) {
        // 가로
        for (int i=0; i<n; i++) {
            if (chess[x][i] == 0) chess[x][i] = depth;
        }

        // 세로
        for (int i=0; i<n; i++) {
            if (chess[i][y] == 0) chess[i][y] = depth;
        }

        // 대각선
        for (int i=0; i<n; i++) {
            // 왼쪽 대각선 위
            if (x - i >= 0 && y - i >= 0 && chess[x - i][y - i] == 0) chess[x - i][y - i] = depth;
            // 왼쪽 대각선 아래
            if (x + i < n && y - i >= 0 && chess[x + i][y - i] == 0) chess[x + i][y - i] = depth;
            // 오른쪽 대각선 위
            if (x - i >= 0 && y + i < n && chess[x - i][y + i] == 0) chess[x - i][y + i] = depth;
            // 오른쪽 대각선 아래
            if (x + i < n && y + i < n && chess[x + i][y + i] == 0) chess[x + i][y + i] = depth;
        }
    }

    static void rollbackQueenPoint(int x, int y, int depth) {
        // 가로
        for (int i=0; i<n; i++) {
            if (chess[x][i] == depth) chess[x][i] = 0;
        }

        // 세로
        for (int i=0; i<n; i++) {
            if (chess[i][y] == depth) chess[i][y] = 0;
        }

        // 대각선
        for (int i=0; i<n; i++) {
            // 왼쪽 대각선 위
            if (x - i >= 0 && y - i >= 0 && chess[x - i][y - i] == depth) chess[x - i][y - i] = 0;
            // 왼쪽 대각선 아래
            if (x + i < n && y - i >= 0 && chess[x + i][y - i] == depth) chess[x + i][y - i] = 0;
            // 오른쪽 대각선 위
            if (x - i >= 0 && y + i < n && chess[x - i][y + i] == depth) chess[x - i][y + i] = 0;
            // 오른쪽 대각선 아래
            if (x + i < n && y + i < n && chess[x + i][y + i] == depth) chess[x + i][y + i] = 0;
        }
    }

    static boolean isEnoughQueenPoint() {
        int[] visited = new int[n + 1];
        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (chess[i][j] == 0) cnt++;
                visited[chess[i][j]]++;
            }
        }

        long visitCount = Arrays.stream(visited).filter(num -> num == 0).count();
        visitCount--; // depth 0 은 제외

        return cnt >= visitCount;
    }
}
