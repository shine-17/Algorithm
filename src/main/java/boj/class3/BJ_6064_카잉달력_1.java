package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6064_카잉달력_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        try {

            int t = Integer.parseInt(br.readLine());

            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                long seq = -1;
                x--;
                y--;

                /*
                    year % m == x
                    year % n == y
                 */

                for(int year=x; year<m*n; year+=m) {
                    if(year % n == y) {
                        seq = year;
                        seq++;
                        break;
                    }
                }

                sb.append(seq).append("\n");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }
}