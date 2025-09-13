package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ_9663_N_Queen_2 {
    static int n, count;
    static int[] chess;
    static ArrayDeque<Queen> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            // 퀸 : 상하좌우, 모든 대각선 이동가능
            n = Integer.parseInt(br.readLine());

            chess = new int[n];

            backTracking(0);

            System.out.println(count);

        } catch (Exception ignored) {}
    }

    static void backTracking(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i=0; i<n; i++) {
            chess[depth] = i;

            if (isPossible(depth)) {
                backTracking(depth+1);
            }
        }
    }

    static boolean isPossible(int depth) {
        for (int i=0; i<depth; i++) {
            if (chess[i] == chess[depth]) return false;

            else if (Math.abs(chess[i] - chess[depth]) == Math.abs(i - depth)) return false;
        }

        return true;
    }

    static class Queen {
        int x;
        int y;

        public Queen(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
