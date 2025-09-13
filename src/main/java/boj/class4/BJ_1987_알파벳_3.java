package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_3 {
    static int r, c;
    static Integer[][] alphabets;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

        static HashSet<Integer> set = new HashSet<>();
//    static LinkedHashSet<Character> set = new LinkedHashSet<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            alphabets = new Integer[r][c];

            for (int i=0; i<r; i++) {
                alphabets[i] = Arrays.stream(br.readLine().split("")).map(s -> s.charAt(0) - 65).toArray(Integer[]::new);
            }

            dfs(0, 0);

            System.out.println(max);

        } catch (Exception ignored) {}
    }

    static void dfs(int x, int y) {
        set.add(alphabets[x][y]);
        max = Math.max(max, set.size());

        if (max == 26) return;

        for (int i=0; i<mx.length; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !set.contains(alphabets[nx][ny])) {
                dfs(nx, ny);
                set.remove(alphabets[nx][ny]);
            }
        }
    }


    static class Alphabet {
        int x;
        int y;

        public Alphabet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}