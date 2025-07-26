package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// bfs 실패 : 메모리초과
public class BJ_1987_알파벳_1 {
    static char[][] alphabets;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            alphabets = new char[r][c];

            for (int i=0; i<r; i++) {
                alphabets[i] = br.readLine().toCharArray();
            }

            int result = bfs(r, c);
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static int bfs(int r, int c) {
        Queue<Alphabet> queue = new ArrayDeque<>();
        queue.add(new Alphabet(0, 0));

//        boolean[][] visited = new boolean[r][c];

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Alphabet current = queue.poll();
            current.add(alphabets[current.x][current.y]);

//            System.out.println(current);

            max = Math.max(max, current.size());

//            if (visited[current.x][current.y]) continue;
//
//            visited[current.x][current.y] = true;

            for (int i=0; i<mx.length; i++) {
                int nx = current.x + mx[i];
                int ny = current.y + my[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !current.contains(alphabets[nx][ny])) {
                    Alphabet alphabet = new Alphabet(nx, ny, current.set);
                    queue.add(alphabet);
                }
            }
        }

        return max;
    }

    static class Alphabet {
        int x;
        int y;

//        HashSet<Character> set = new LinkedHashSet<>();
        HashSet<Character> set = new HashSet<>();

        public Alphabet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Alphabet(int x, int y, HashSet<Character> set) {
            this.x = x;
            this.y = y;
            this.set.addAll(set);
        }

        public void add(char c) {
            set.add(c);
        }

        public boolean contains(char c) {
            return set.contains(c);
        }

        public int size() {
            return set.size();
        }
    }
}