package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이만들기_1 {
    static int[][] papers;
    static int bCount;
    static int wCount;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());

            papers = new int[n][n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<n; j++) {
                    papers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cutPaper(0, 0, n);
            System.out.println(wCount);
            System.out.println(bCount);

        } catch(Exception ignored) {}
    }

    static void cutPaper(int x, int y, int length) {
        if(isAllSame(x, y, length)) {
            if(papers[x][y] == 1) bCount++;
            else wCount++;
        }
        else {
            int newLength = length / 2;

            cutPaper(x, y, newLength);
            cutPaper(x, y + newLength, newLength);
            cutPaper(x + newLength, y, newLength);
            cutPaper(x + newLength, y + newLength, newLength);
        }

    }

    static boolean isAllSame(int x, int y, int length) {
        boolean result = true;
        int num = papers[x][y];

        for(int i=x; i<x + length; i++) {
            for(int j=y; j<y + length; j++) {
                if(num != papers[i][j]) return false;
            }
        }

        return result;
    }


}
