package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리_1 {
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


            int[] dp = new int[n];
            int min = 0;

            for (char color : rgbs) {
                homes[0].color = color;
                int sum = 0;
                if (color == 'r') sum = homes[0].RED;
                else if (color == 'g') sum = homes[0].GREEN;
                else if (color == 'b') sum = homes[0].BLUE;

                for (int i=1; i<n; i++) {
                    char prevColor = homes[i-1].color;

                    for (int j=i; j>=0; j--) {
                        if (prevColor == homes[j].color) continue;

                        if (prevColor == R) {
                            if (homes[j].GREEN < homes[j].BLUE) {

                            }
                            Math.min(homes[j].GREEN, homes[j].BLUE);
                        }
                    }

                    min = Math.min(min, dp[i]);
                }
            }



        } catch (Exception ignored) {}
    }

    static class Home {
        char color;
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
