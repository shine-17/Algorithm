package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색_1 {
    static int[][] maze;
    static boolean[][] visited;

    static int n;
    static int m;

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            maze = new int[n][m];
            visited = new boolean[n][m];

            for(int i=0; i<n; i++) {
                String[] split = br.readLine().split("");

                for(int j=0; j<split.length; j++) {
                    maze[i][j] = Integer.parseInt(split[j]);
                }
            }

            Block block = new Block(0, 0);
            int count = findMaze(block);

            System.out.println(count);

        } catch(Exception ignored) {}
    }

    static int findMaze(Block block) {
        visited[block.x][block.y] = true;

        int[][] distance = new int[n][m];
        distance[block.x][block.y] = 1;

        Queue<Block> queue = new LinkedList<>();
        queue.add(block);

        while(!queue.isEmpty()) {
            Block sideBlock = queue.poll();

//            System.out.println("sideBlock : " + sideBlock.x + ", " + sideBlock.y + " - [" + distance[sideBlock.x][sideBlock.y] + "]");

            for(int i=0; i<mx.length; i++) {
                int nx = sideBlock.x + mx[i];
                int ny = sideBlock.y + my[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Block(nx, ny));
                    distance[nx][ny] = distance[sideBlock.x][sideBlock.y] + 1;
                }
            }
        }

        return distance[n-1][m-1];
    }

    static class Block {
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
