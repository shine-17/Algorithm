package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9663_N_Queen_1 {
    static int[] chess;
    static int n;
    static int count;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            n = Integer.parseInt(br.readLine());
            chess = new int[n];

            // 인덱스: 행, 값: 열
            findQueenPoint(0);

            System.out.println(count);

        } catch (Exception ignored) {}
    }

    static void findQueenPoint(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i=0; i<n; i++) {
            chess[depth] = i;

            if (possibleQueenPoint(depth)) {
                findQueenPoint(depth + 1);
            }
        }
    }

    static boolean possibleQueenPoint(int depth) {
        for (int i=0; i<depth; i++) {
            // 같은 행에 퀸이 올 수 있는지
            if (chess[depth] == chess[i]) return false;

            // 대각선 경로에 퀸이 올 수 있는지
            else if (Math.abs(chess[depth] - chess[i]) == Math.abs(depth - i)) return false;
        }

        return true;
    }

}
