package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_6064 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            int[][] calendars = new int[t][4];

            for(int i=0; i<t; i++) {
                String[] lines = br.readLine().split(" ");

                for(int j=0; j<lines.length; j++) {
                    calendars[i][j] = Integer.parseInt(lines[j]);
                }
            }

            for(int i=0; i<calendars.length; i++) {

                int m = calendars[i][0];
                int n = calendars[i][1];
                int x = calendars[i][2];
                int y = calendars[i][3];

                int year = getCainYear(m, n, x, y);
                System.out.println(year);
            }

        } catch (Exception e) {

        }
    }

    private static int getCainYear(int m, int n, int x, int y) {
        int year = x;
        int y2 = 0;
        boolean flag = false; // 유효하지 않은 값 체크 판단 플래그
        int destructionYear = getLcm(m, n);

        try {

            for(int i=x; i<=destructionYear; i+=m) {
                y2 = i % n == 0 ? n : i % n;

                if(y2 == y) {
                    year = i;
                    flag = true;
                    break;
                }
            }

            if(!flag) year = -1;

        } catch (Exception e) {
            year = -1;
        }

        return year;
    }

    /**
     * 유클리드 호제법 알고리즘
     */
    //최대공약수
    private static int getGcd(int a, int b) {
        if(b == 0) return a;

        return getGcd(b, a % b);
    }

    //최소공배수
    private static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }

}
