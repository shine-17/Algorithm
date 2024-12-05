package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BJ_10026_적록색약 {
    static char[][] rgb;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            rgb = new char[n][n];

            for(int i=0; i<n; i++) {
                rgb[i] = br.readLine().toCharArray();
            }

            int[] colors = new int[2];
            visited = new boolean[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    boolean isCheck = findColorSection(i, j, false);
                    if(isCheck) colors[0]++;
                }
            }

            visited = new boolean[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    boolean isCheck = findColorSection(i, j, true);
                    if(isCheck) colors[1]++;
                }
            }

            System.out.println(colors[0] + " " + colors[1]);

        } catch(Exception ignored) {}
    }

    static boolean findColorSection(int x, int y, boolean isColorBlindness) {
        if(visited[x][y]) return false;

        visited[x][y] = true;

        Color startNode = new Color(x, y);
        char color = rgb[x][y];

        // 색약이고 R, G 일 때만 RG 같이 초기화. RG 구분이 없어야 하기 때문
        List<Character> colorList = isColorBlindness && (color == 'R' || color == 'G') ? List.of('R', 'G') : List.of(color);

        Queue<Color> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()) {
            Color node = queue.poll();

            for(int i=0; i<mx.length; i++) {
                int nx = node.x + mx[i];
                int ny = node.y + my[i];

                try {

                    if(colorList.contains(rgb[nx][ny]) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Color(nx, ny));
                    }

                } catch (Exception ignored) {}
            }
        }

        return true;
    }

    static class Color {
        int x;
        int y;

        public Color(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
