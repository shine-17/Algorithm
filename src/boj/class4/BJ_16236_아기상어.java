package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_16236_아기상어 {
    static int n;
    static int[][] ocean;
    static Fish babyShark;
    static List<Fish> fish = new ArrayList<>();

    static final int SHARK_SIZE = 2;
    static final int INF = 400;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            /*
                아기 상어
                - 처음 크기 : 1
                - 1초에 상하좌우로 한 칸씩 이동
                - 자신의 크기보다 큰 물고기가 있는 칸을 제외하고 모두 이동 가능
                - 자신의 크기보다 작은 물고기만 먹을 수 있음

                - 더 이상 먹을 수 있는 물고기가 없으면 엄마 상어에게 도움 요청
                - 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
                - 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
                    - 거리는 최단거리다.
                    - 거리가 가까운 물고기가 많다면 우선순위는 가장 위에 있는 물고기 > 가장 왼쪽에 있는 물고기

                - 물고기를 먹으면 빈 칸이 된다.
                - 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
                    - ex) 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

                아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 사냥할 수 있는지

                0: 빈 칸
                1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
                9: 아기 상어의 위치
            */


            n = Integer.parseInt(br.readLine());
            ocean = new int[n][n];
            for (int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");
                for (int j=0; j< split.length; j++) {
                    int value = Integer.parseInt(split[j]);
                    ocean[i][j] = value;

                    if (value == 9) babyShark = new Fish(i, j, SHARK_SIZE);
                    else if (value > 0) fish.add(new Fish(i, j, value));
                }
            }

            if (isStartable()) {
                huntingFish();
                System.out.println(babyShark.time);
            }
            else {
                System.out.println(0);
            }


        } catch (Exception ignored) {}
    }

    static void huntingFish() {
        while (true) {
            List<Fish> list = fish.stream().filter(s -> s.size < babyShark.size).collect(Collectors.toList());

            TreeSet<Fish> set = new TreeSet<>(new Comparator<Fish>() {
                @Override
                public int compare(Fish o1, Fish o2) {
                    if (o1.length == o2.length) {
                        if (o1.x == o2.x) return o1.y - o2.y;

                        return o1.x - o2.x;
                    }

                    return o1.length - o2.length;
                }
            });

            if (!list.isEmpty()) {
                for (Fish f : list) {
                    f.length = find(f);
                    set.add(f);
                }

                Fish first = set.first();

                if (first.length >= INF) break;

                babyShark.time += first.length;
                huntingFish(first);
            }
            else {
                break;
            }
        }
    }

    static int find(Fish f) {
        Queue<Fish> queue = new ArrayDeque<>();
        queue.add(babyShark);

        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i=0; i<dist.length; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[babyShark.x][babyShark.y] = 0;

        while (!queue.isEmpty()) {
            Fish current = queue.poll();

            if (visited[current.x][current.y]) continue;

            visited[current.x][current.y] = true;

            for (int i=0; i<mx.length; i++) {
                int nx = current.x + mx[i];
                int ny = current.y + my[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && ocean[nx][ny] <= babyShark.size && dist[nx][ny] > dist[current.x][current.y] + 1) {
                    dist[nx][ny] = dist[current.x][current.y] + 1;
                    queue.add(new Fish(nx, ny, ocean[nx][ny]));
                }
            }
        }

        return dist[f.x][f.y];
    }


    static void huntingFish(Fish f) {
        ocean[babyShark.x][babyShark.y] = 0;
        babyShark.x = f.x;
        babyShark.y = f.y;
        babyShark.count++;
        babyShark.levelUp();

        ocean[f.x][f.y] = 0;
        fish.remove(f);
    }

    static boolean isStartable() {
        for (int i=0; i<mx.length; i++) {
            int nx = babyShark.x + mx[i];
            int ny = babyShark.y + my[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && ocean[nx][ny] <= babyShark.size) {
                return true;
            }
        }

        return false;
    }

    static class Fish {
        int x;
        int y;
        int size;       // 아기상어의 크기

        int count;      // 아기상어의 레벨업하기 위한 물고기 마리수
        int time;       // 아기상어의 시간
        int length;     // 아기상어로부터 물고기까지의 거리

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public void levelUp() {
            if (count == size) {
                size++;
                count = 0;
            }
        }
    }
}
