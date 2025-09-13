package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_18111_마인크래프트_1 {
    static int[][] site;
    static TreeMap<Integer, Integer> timeMap;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            timeMap = new TreeMap<>();
            site = new int[n][m];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i=0; i<n; i++) {
                String[] split = br.readLine().split(" ");

                for(int j=0; j<split.length; j++) {
                    int num = Integer.parseInt(split[j]);
                    site[i][j] = num;

                    max = Math.max(max, num);
                    min = Math.min(min, num);
                }
            }

            for(int i=min; i<=max; i++) {
                flatSite(i, b);
            }

            System.out.println(timeMap.firstEntry().getKey() + " " + timeMap.firstEntry().getValue());

        } catch (Exception ignored) {}
    }

    static void flatSite(int height, int inventory) {
        int time = 0;

        for(int i=0; i<site.length; i++) {
            for(int j=0; j<site[i].length; j++) {
                int num = site[i][j];
/*
                1. 인벤토리에 블록이 있으면 쌓음
                2. 인벤토리에 블록이 부족하면 빼야함
 */
                int diff = num - height;

                if(diff > 0) {
                    diff = Math.abs(diff);

                    time += (diff * 2); // 블록 제거는 2초
                    inventory += diff;
                }
                else if(diff < 0) {
                    diff = Math.abs(diff);

                    inventory -= diff;
                    time += diff; // 블록 추가는 1초
                }
            }
        }

        if(inventory >= 0) {
            height = timeMap.get(time) != null && timeMap.get(time) > height ? timeMap.get(time) : height;
            timeMap.put(time, height);
        }
    }
}
