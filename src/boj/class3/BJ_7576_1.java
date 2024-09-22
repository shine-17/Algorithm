package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_1 {

    static int m;
    static int n;
    static int[][] tomatos;
    static Queue<Tomato> ripenTomatos = new LinkedList<>(); //익은 토마토 좌표
    static int unripenTomatos; //익지 않은 토마토 개수(좌표로 저장할 필요 X)
    static int day = Integer.MIN_VALUE;

    static int[] tx = {-1, 0, 1, 0};
    static int[] ty = {0, -1, 0, 1};

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            tomatos = new int[n][m];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<m; j++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatos[i][j] = tomato;

                    if(tomato == 1) {
                        ripenTomatos.add(new Tomato(i, j));
                    }
                    else if(tomato == 0) {
                        unripenTomatos++;
                    }
                }
            }

            if(unripenTomatos == 0) {
                System.out.println(0);
            } else {
                checkTomato();

                if(unripenTomatos > 0) day = -1;
                else day--;

                System.out.println(day);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void checkTomato() {
        while(!ripenTomatos.isEmpty()) {
            Tomato tomato = ripenTomatos.poll();

            for(int i=0; i<4; i++) {
                int x = tomato.x + tx[i];
                int y = tomato.y + ty[i];


                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(tomatos[x][y] == 0) {
                        ripenTomatos.add(new Tomato(x, y));
                        tomatos[x][y] = tomato.getTomato() + 1;
                        unripenTomatos--;

                        day = Math.max(day, tomatos[x][y]);
                    }
                }
            }
        }
    }

    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getTomato() {
            return tomatos[x][y];
        }
    }

}
