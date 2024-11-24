package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14940_쉬운최단거리 {
    static int[][] map;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new int[n][m];

            for(int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");

                for(int j=0; j<m; j++) {
                    map[i][j] = Integer.parseInt(split[j]);
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        } catch(Exception ignored) {}
    }

    static void findPath(int[][] map) {

    }
}
