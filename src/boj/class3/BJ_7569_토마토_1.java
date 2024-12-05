package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토_1 {
    static int[][][] tomatos;
    static boolean[][][] visited;
    static int unripenTomatos;
    static Queue<Tomato> ripenTomatos = new LinkedList<>();

    static int mx[] = {-1, 0, 1, 0, 0, 0};
    static int my[] = {0, 1, 0, -1, 0, 0};
    static int mz[] = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            tomatos = new int[h][n][m];
            visited = new boolean[h][n][m];

            for(int i=0; i<h; i++) {
                for(int j=0; j<n; j++) {
                    st = new StringTokenizer(br.readLine());

                    for(int k=0; k<m; k++) {
                        tomatos[i][j][k] = Integer.parseInt(st.nextToken());

                        if(tomatos[i][j][k] == 0) {
                            unripenTomatos++;
                        }
                        else if(tomatos[i][j][k] == 1) {
                            ripenTomatos.add(new Tomato(k, j, i));
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            // 저장될 때부터 모두 익어있는 상태: 0
            if(unripenTomatos == 0) {
                sb.append(0);
            }
            else {
                int num = ripenTomatos();
                int count = unripenTomatos > 0 ? -1 : num;
                sb.append(count);
            }

            System.out.println(sb);

        } catch (Exception ignored) {}
    }

    static int ripenTomatos() {
        int day = 0;

        while(!ripenTomatos.isEmpty()) {
            Tomato tomato = ripenTomatos.poll();

            for(int i=0; i<mx.length; i++) {
                int x = tomato.x + mx[i];
                int y = tomato.y + my[i];
                int z = tomato.z + mz[i];

                if(x >= 0 && x < tomatos[0][0].length && y >= 0 && y < tomatos[0].length && z >= 0 && z < tomatos.length && tomatos[z][y][x] == 0) {
                    unripenTomatos--;
                    tomatos[z][y][x] = tomatos[tomato.z][tomato.y][tomato.x] + 1;
                    day = tomatos[z][y][x];

                    ripenTomatos.add(new Tomato(x, y, z));
                }
            }
        }

        return --day;
    }

    static class Tomato {
        int x;
        int y;
        int z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
