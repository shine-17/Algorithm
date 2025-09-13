package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15686_치킨배달 {
    static Home[][] city;
    static List<Home> homes = new ArrayList<>();
    static List<Home> chickens = new ArrayList<>();
    static boolean[] visited;
    static int m;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            city = new Home[n + 1][n + 1];

            for (int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j=1; j<=n; j++) {
                    int status = Integer.parseInt(st.nextToken());

                    // 0: 빈 집, 1: 집, 2: 치킨집
                    Home home = new Home(i, j);
                    city[i][j] = new Home(i, j);

                    if (status == 1) homes.add(home);
                    else if (status == 2) chickens.add(home);
                }
            }

            visited = new boolean[chickens.size() + 1];

            // backtracking
            findChickenDistance(0, 0);

            System.out.println(min);

        } catch (Exception ignored) {}
    }

    static void findChickenDistance(int start, int depth) {

        if (depth == m) {
            int sum = 0;

            for (Home home : homes) {
                int minDistance = Integer.MAX_VALUE;

                for (int j=0; j<chickens.size(); j++) {
                    if (visited[j]) {
                        Home chicken = chickens.get(j);

                        int distance = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
                        minDistance = Math.min(minDistance, distance);
                    }
                }

                sum += minDistance;
            }

            min = Math.min(sum, min);
            return;
        }

        for (int i=start; i<chickens.size(); i++) {
            visited[i] = true;
            findChickenDistance(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static class Home {
        int x;
        int y;
        int distance;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
