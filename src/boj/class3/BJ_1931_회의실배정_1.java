package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1931_회의실배정_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = null;

            int[][] rooms = new int[n][2];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                rooms[i][0] = start;
                rooms[i][1] = end;
            }

            Arrays.sort(rooms, new Comparator<>() {
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }

                    return o1[1] - o2[1];
                }
            });

            int count = 0;
            int prev_end_time = 0;

            for(int i=0; i<n; i++) {
                if(rooms[i][0] >= prev_end_time) {
                    prev_end_time = rooms[i][1];
                    count++;
                }
            }

            System.out.println(count);

        } catch(Exception ignored) {}
    }
}
