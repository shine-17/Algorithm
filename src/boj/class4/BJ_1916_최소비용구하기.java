package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1916_최소비용구하기 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            LinkedList<Bus> buses = new LinkedList<>();

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                buses.add(new Bus(start, end, cost));
            }

            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());

            int minimumCost = findMinimumCost(n, buses, startCity, endCity);

            System.out.println(minimumCost);

        } catch (Exception ignored) {}
    }

    static int findMinimumCost(int n, Queue<Bus> queue, int start, int end) {
        int[][] dist = new int[n+1][n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            Bus bus = queue.poll();

            dist[bus.start][bus.end] = Math.min(dist[bus.start][bus.end], bus.cost);

            // 4,5 -> 4,1
            // 1,2 / 1,3 / 1,4 / 1,5 -> 2,3,4,5 -> 2,4 / 3,4 / 4,5
        }

        return dist[start][end];
    }


    static class Bus {
        int start;
        int end;
        int cost;

        public Bus(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Bus{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }
}
