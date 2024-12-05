package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z_1 {
    static int[][] zArr;
    static int count = -1;
    static int answer;
    static int[] mx = {0, 0, 1, 1};
    static int[] my = {0, 1, 0, 1};
    static int r, c;
    static int x, y;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int len = (int) Math.pow(2, n);

            findArr(len, 0, 0);

            System.out.println(answer);

        } catch(Exception ignored) {}
    }

    private static void findArr(int len, int startX, int startY) {
        if(len > 2) {
            len /= 2;

            int prevCount = len*len;

            // 1사분면
            if(r < startX + len && c < startY + len) {
                findArr(len, startX, startY);
            }
            // 2사분면
            else if(r < startX + len && c < startY + (len*2)) {
                count += prevCount;
                findArr(len, startX, startY + len);
            }
            // 3사분면
            else if(r < startX + (len*2) && c < startY + len) {
                count += (prevCount*2);
                findArr(len, startX + len, startY);
            }
            // 4사분면
            else {
                count += (prevCount*3);
                findArr(len, startX + len, startY + len);
            }
        }
        else {
            for(int i=0; i<mx.length; i++) {
                x = startX + mx[i];
                y = startY + my[i];
                count++;

                if(r == x && c == y) {
                    answer = count;
                    return;
                }
            }
        }
    }
}
