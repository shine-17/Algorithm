package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {

    static int m;
    static int n;
    static int[][] tomatos;
    static Deque<Tomato> ripenTomatos = new LinkedList<>(); //익은 토마토 좌표
    static int unripenTomatos; //익지 않은 토마토 개수(좌표로 저장할 필요 X)
    static int day;

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
                System.out.println(day);
                return;
            }

            while(unripenTomatos != 0) {
                if(ripenTomatos.isEmpty()) {
                    day = -1;
                    break;
                }

                int size = ripenTomatos.size();
                for(int i=0; i<size; i++) {
                    checkTomato(ripenTomatos.pop());
                }

                day++;
            }

            System.out.println(day);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void checkTomato(Tomato tomato) {
        if(tomato == null) return;

        for(int i=0; i<tx.length; i++) {
            int x = tomato.x + tx[i];
            int y = tomato.y + ty[i];

            try {
                if(tomatos[x][y] == 0) {
                    tomatos[x][y]++;
                    ripenTomatos.add(new Tomato(x, y));
                    unripenTomatos--;
                }
            } catch (Exception e) {}
        }
    }

    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
