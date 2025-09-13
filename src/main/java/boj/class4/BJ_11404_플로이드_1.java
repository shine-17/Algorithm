package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11404_플로이드_1 {
    static int n;
    static int[][] routes;
    static int[][] dist;
    static final int INF = 100 * 100000;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            n = Integer.parseInt(br.readLine()); // 도시의 개수
            int m = Integer.parseInt(br.readLine()); // 버스의 개수

            routes = new int[n+1][n+1];
            dist = new int[n+1][n+1];

            for (int i=0; i<m; i++) {
                st  = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()); // 시작 도시
                int b = Integer.parseInt(st.nextToken()); // 도착 도시
                int c = Integer.parseInt(st.nextToken()); // 비용

                routes[a][b] = Math.min(routes[a][b] == 0 ? INF : routes[a][b], c);
            }


            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (i == j) dist[i][j] = 0;
                    else if (routes[i][j] != 0) dist[i][j] = routes[i][j];
                    else dist[i][j] = INF;
                }
            }

            for (int k=1; k<=n; k++) {
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

                        // dist[1][2] = Math.min(dist[1][2], dist[1][k] + dist[k][2]);
                        // k=1 : Math.min(dist[1][2], dist[1][1] + dist[1][2]);
                        // k=2 : Math.min(dist[1][2], dist[1][2] + dist[2][2]);
                        // k=3 : Math.min(dist[1][2], dist[1][3] + dist[3][2]);
                        // k=4 : Math.min(dist[1][2], dist[1][4] + dist[4][2]);

                        // 1 -> 3 -> 4 -> 2
                        // k=5 : Math.min(dist[1][2], dist[1][5] + dist[5][2]);
                    }
                }
            }

            StringBuilder result = new StringBuilder();

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    result.append(dist[i][j] >= INF ? 0 : dist[i][j]).append(" ");
                }
                result.append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }
}
