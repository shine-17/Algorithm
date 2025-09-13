package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15686_치킨배달_1 {
    static int[][] city;
    static int m;
    static List<Place> homes = new ArrayList<>();
    static List<Place> chickens = new ArrayList<>();
    static List<Place> openChickens = new ArrayList<>();

    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            city = new int[n][n];

            for (int i=0; i<n; i++) {
                int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j=0; j<n; j++) {
                    int column = array[j];
                    city[i][j] = column;

                    if (column == 1) homes.add(new Place(i, j));
                    else if (column == 2) chickens.add(new Place(i, j));
                }
            }

            visited = new boolean[chickens.size()];

            if (chickens.size() == m) min = getChickenDistanceSum(chickens);
            else backTracking(0, 0);

            System.out.println(min);

        } catch (Exception ignored) {}
    }

    static void backTracking(int at, int depth) {
        if (depth == m) {
            min = Math.min(min, getChickenDistanceSum(openChickens));
            return;
        }

        if (at == chickens.size()) return;

        for (int i=at; i<chickens.size(); i++) {
            visited[i] = true;
            openChickens.add(chickens.get(i));
            backTracking(i+1, depth+1);
            openChickens.remove(openChickens.size()-1);
            visited[i] = false;
        }
    }

    static int getChickenDistanceSum(List<Place> chickens) {
        int sum = 0;

        for (Place home : homes) {
            int distance = Integer.MAX_VALUE;

            for (Place chicken : chickens) {
                distance = Math.min(distance, betweenDistance(home, chicken));
            }

            sum += distance;
        }

        return sum;
    }

    static int betweenDistance(Place start, Place end) {
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
    }

    static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
