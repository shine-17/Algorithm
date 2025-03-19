package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2448_별찍기_11 {
    static final int LENGTH = 3;
    static final int WIDTH = 5;
    static char[][] stars;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            /*
                1x = 5
                2x = 11
                4x = 23

                6n - 1

                6(n / 3) - 1
                = 2n - 1
             */

            // 2n - 1

            stars = new char[n][2 * n - 1];

            // n / 3 = 라인 수
            // 3 * 5 사이즈
            // 현재 별 집합이 아래에 2개 더 추가됨

            StringBuilder result = new StringBuilder();

            /*


             */

            drawStars(n, 2 * n - 1, n);

            for (int i=0; i<stars.length; i++) {
                for (int j=0; j<stars[i].length; j++) {
                    result.append(stars[i][j] == 0 ? ' ' : stars[i][j]);
                }
                result.append('\n');
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void drawStars(int x, int y, int n) {

        if (n == 3) {
            // x: 3, y: 5
            x -= LENGTH;
            y -= WIDTH;

            for (int i=x; i<x + LENGTH; i++) {
                if (i == x) stars[i][y + 2] = '*';
                else if (i == x + 1) stars[i][y + 1] = stars[i][y + 3] = '*';
                else stars[i][y] = stars[i][y + 1] = stars[i][y + 2] = stars[i][y + 3] = stars[i][y + 4] = '*';
            }
        }
        else {
            // 6, 11, 6
            // 12, 23, 12
            // 24, 47, 24

            // y - (((y - 1) / 2) / 2 + 1)


            drawStars(x - (n / 2), y - (n / 2), n / 2);   // 위 삼각형
            drawStars(x, y - n, n / 2);                     // 왼쪽 삼각형
            drawStars(x, y, n / 2);                       // 오른쪽 삼각형

            // 12, 23, 12
            // 12, 23, 6
            //

            /*
                drawStars(n, 2 * n - 1, n);

                n= 12
                x= 12, y= 23, n= 12

                1. 6, 17, 6
                2. 12, 11, 6
                3. 12, 23, 6

                n= 6
                6, 17, 6

                1. 3, 3, 3
                2.


             */


        }
    }
}
