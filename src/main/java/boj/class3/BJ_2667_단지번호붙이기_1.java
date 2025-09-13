package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2667_단지번호붙이기_1 {
    static int[][] map;
    static boolean[][] visited;
    static int count;

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            for(int i=0; i<n; i++) {
                String[] split = br.readLine().split("");

                for(int j=0; j<split.length; j++) {
                    map[i][j] = Integer.parseInt(split[j]);
                }
            }

            List<Integer> complexList = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    count = 0;
                    findComplex(i, j);

                    if(count > 0) complexList.add(count);
                }
            }

            Collections.sort(complexList);

            StringBuilder sb = new StringBuilder();
            sb.append(complexList.size()).append("\n");

            for(Integer count : complexList) {
                sb.append(count).append("\n");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }

    static void findComplex(int x, int y) {
        if(map[x][y] == 0 || visited[x][y]) return;

        visited[x][y] = true;
        count++;

        for(int i=0; i<mx.length; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && !visited[nx][ny] && map[nx][ny] == 1) {
                findComplex(nx, ny);
            }
        }

    }
}
