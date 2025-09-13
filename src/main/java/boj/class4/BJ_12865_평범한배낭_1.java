package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Item[] items = new Item[n+1];

            for (int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());

                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                items[i] = new Item(w, v);
            }

            int[][] dp = new int[n+1][k+1];

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=k; j++) {

                    if (items[i].w > j) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i].w] + items[i].v);
                    }
                }
            }

            System.out.println(dp[n][k]);

        } catch (Exception ignored) {}
    }

    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
