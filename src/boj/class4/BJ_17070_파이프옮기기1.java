package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
    static Home[][] homes;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            homes = new Home[n+1][n+1];

            for (int i=1; i<=n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=1; j<=n; j++) {
                    homes[i][j] = new Home(i, j, Integer.parseInt(st.nextToken()));
                }
            }

            System.out.println(findPipePath(n));

        } catch (Exception ignored) {}
    }

    static int findPipePath(int n) {
        Queue<Home> queue = new ArrayDeque<>();

        // 파이프 (1,1) (1,2) 고정, (1,2) 시작
        Home home = homes[1][2];
        home.form = 0;
        queue.add(home);
        int count = 0;

        while (!queue.isEmpty()) {
            home = queue.poll();

            /*
                가로, 세로, 대각선

                1. 벽이 있으면 진행 X, 대각선은 3개 칸이 벽이면 안됨
                2. 가로, 세로는 마지막 인덱스에 접근X 대각선만 가능
             */

//            System.out.println(home.x + " " + home.y + " " + home.form);

            // 도착
            if (home.x == n && home.y == n) {
                count++;
                continue;
            }

            // 가로: 가로, 대각선 가능
            if (home.form != 1 && home.y + 1 <= n) {
                if (homes[home.x][home.y + 1].status != 1) queue.add(new Home(home.x, home.y + 1, 0L));
            }

            // 세로: 세로, 대각선 가능
            if (home.form != 0 && home.x + 1 <= n) {
                if (homes[home.x + 1][home.y].status != 1) queue.add(new Home(home.x + 1, home.y, 1L));
            }

            // 대각선: 가로, 세로, 대각선 모두 가능
            if (home.x + 1 <= n && home.y + 1 <= n) {
                if (homes[home.x + 1][home.y].status != 1 && homes[home.x][home.y + 1].status != 1 && homes[home.x + 1][home.y + 1].status != 1)
                    queue.add(new Home(home.x + 1, home.y + 1, 2L));
            }
        }

        return count;
    }

    static class Home {
        int x;
        int y;
        int status; // 0: 빈 칸, 1: 벽
        long form; // 0: 가로, 1: 세로, 2: 대각선

        public Home(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }

        public Home(int x, int y, long form) {
            this.x = x;
            this.y = y;
            this.form = form;
        }
    }
}
