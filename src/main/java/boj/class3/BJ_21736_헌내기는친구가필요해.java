package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21736_헌내기는친구가필요해 {
    static char[][] campus;
    static boolean[][] visited;
    static int peopleCount;

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            campus = new char[n][m];
            visited = new boolean[n][m];
            int x = 0, y = 0; // 도연이의 위치

            for(int i=0; i<n; i++) {
                String split = br.readLine();

                for(int j=0; j<split.length(); j++) {
                    campus[i][j] = split.charAt(j);

                    if(campus[i][j] == 'I') {
                        x = i;
                        y = j;
                    }
                }
            }

            findFriends(x, y);
            System.out.println(peopleCount == 0 ? "TT" : peopleCount);

        } catch(Exception ignored) {}
    }

    static void findFriends(int x, int y) {
        visited[x][y] = true;

        if(campus[x][y] == 'P') peopleCount++;
        else if(campus[x][y] == 'X') return;

        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < campus.length && ny >= 0 && ny < campus[0].length && !visited[nx][ny]) {
                findFriends(nx, ny);
            }
        }
    }
}
