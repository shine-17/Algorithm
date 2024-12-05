package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토_2 {
    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] tomatos = new int[n][m];
            int unripeTomatos = 0;
            Queue<Tomato> queue = new LinkedList<>();

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<m; j++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatos[i][j] = tomato;

                    if(tomato == 0) unripeTomatos++;
                    else if(tomato == 1) queue.add(new Tomato(i, j));
                }
            }

            StringBuilder sb = new StringBuilder();
            if(unripeTomatos == 0) {
                sb.append(0);
            }
            else {
                int day = ripenTomatos(tomatos, queue, unripeTomatos);
                sb.append(day);
            }

            System.out.println(sb);

        } catch (Exception ignored) {}
    }

    static int ripenTomatos(int[][] tomatos, Queue<Tomato> queue, int unripeTomatos) {
        int[] mx = {-1, 0, 1, 0};
        int[] my = {0, -1, 0, 1};
        int day = 0;

        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for(int i=0; i<mx.length; i++) {
                int x = tomato.x + mx[i];
                int y = tomato.y + my[i];

                try {
                    if(tomatos[x][y] != 0) continue;

                    tomatos[x][y] = day = tomatos[tomato.x][tomato.y] + 1;
                    unripeTomatos--;
                    queue.add(new Tomato(x, y));
                } catch (Exception ignored) {}
            }
        }

        return unripeTomatos > 0 ? -1 : --day;
    }
}
