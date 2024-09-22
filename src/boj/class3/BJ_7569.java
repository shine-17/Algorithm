package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_7569 {

    static int[][][] tomatos;
    static Deque<Tomato> ripenTomatos = new LinkedList<>(); //익은 토마토 좌표
    static int unripenTomatos; //익지 않은 토마토 개수(좌표로 저장할 필요 X)
    static int day;

    static int dx[] = {-1, 0, 1, 0, 0, 0};
    static int dy[] = {0, 1, 0, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        // 토마토
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            tomatos = new int[h][n][m];

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

            // 저장될 때부터 모두 익어있는 상태: 0
            if(unripenTomatos == 0) {
                System.out.println(0);
                return;
            }

            while(unripenTomatos != 0) {

                int count = 0;
                int size = ripenTomatos.size();
                for(int i=0; i<size; i++) {
                    count += ripenTomatos(ripenTomatos.pollFirst());
                }

                day++;
//                System.out.println("[" + day + "] count: " + count + ", unripenTomatos: " + unripenTomatos.size()+ ", ripenTomatos: " + ripenTomatos.size());
                if(unripenTomatos == 0) {
                    break;
                }
                else if(count == 0) {
                    day = -1;
                    break;
                }
            }

            System.out.println(day);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //BFS
    static int ripenTomatos(Tomato tomato) {
        int ripenCount = 0;
        int h = tomato.z;
        int n = tomato.y;
        int m = tomato.x;

        for (int i=0; i<6; i++) {
            int nx = m + dx[i];
            int ny = n + dy[i];
            int nz = h + dz[i];

            if(nz < 0 || nz >= tomatos.length || ny < 0 || ny >= tomatos[h].length || nx < 0 || nx >= tomatos[h][n].length) continue;
            if(tomatos[nz][ny][nx] == -1 || tomatos[nz][ny][nx] == 1) continue;

            tomatos[nz][ny][nx] = 1;
            ripenTomatos.add(new Tomato(nx ,ny, nz));
            unripenTomatos--;
            ripenCount++;
        }

        return ripenCount;
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

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Tomato) {
                Tomato tomato = (Tomato) obj;
                if(this.x != tomato.x) return false;
                if(this.y != tomato.y) return false;
                return this.z == tomato.z;
            }

            return false;
        }
    }

}
