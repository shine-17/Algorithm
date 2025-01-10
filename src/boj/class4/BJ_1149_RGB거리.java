package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실패 : 시간초과
public class BJ_1149_RGB거리 {
    static final char R = 'r';
    static final char G = 'g';
    static final char B = 'b';
    static char[] rgbs = new char[] {R, G, B};
    static Home[] homes;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            homes = new Home[n];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                homes[i] = new Home(r, g, b);
            }

            int min = Integer.MAX_VALUE;

            for (char color : rgbs) {
                min = Math.min(findRGB(0, 0, color), min);
            }

            System.out.println(min);

        } catch (Exception ignored) {}
    }

    static int findRGB(int sum, int index, char color) {
        if (index == homes.length) return sum;

        if (color == R) {
            return Math.min(findRGB(sum + homes[index].GREEN, index + 1, G), findRGB(sum + homes[index].BLUE, index + 1, B));
        }
        else if (color == G) {
            return Math.min(findRGB(sum + homes[index].RED, index + 1, R), findRGB(sum + homes[index].BLUE, index + 1, B));
        }
        else if (color == B) {
            return Math.min(findRGB(sum + homes[index].RED, index + 1, R), findRGB(sum + homes[index] .GREEN,index + 1, G));
        }

        return 0;
    }

    static class Home {
        int RED;
        int GREEN;
        int BLUE;

        public Home(int RED, int GREEN, int BLUE) {
            this.RED = RED;
            this.GREEN = GREEN;
            this.BLUE = BLUE;
        }
    }
}
