package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1916_최소비용구하기 {
    static final int MAX = 100001;
    static ArrayList<Bus>[] busList;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            busList = new ArrayList[n+1];

            for (int i=1; i<=n; i++) {
                busList[i] = new ArrayList<>();
            }

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                Bus bus = new Bus(start, end, cost);

                busList[start].add(bus);
            }

            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());

            int minimumCost = findMinimumCost(n, startCity, endCity);

            System.out.println(minimumCost);

            Runtime.getRuntime().gc();
            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.print(usedMemory + " bytes");

        } catch (Exception ignored) {}
    }

    static int findMinimumCost(int n, int start, int end) {
        int[][] dist = new int[n+1][n+1];

        for (int i=1; i<dist.length; i++) {
            Arrays.fill(dist[i], MAX);
        }

        Queue<Bus> queue = new LinkedList<>(busList[start]);

        while (!queue.isEmpty()) {
            Bus bus = queue.poll();

            if (dist[bus.start][bus.end] == MAX) dist[bus.start][bus.end] = Math.min(dist[bus.start][bus.end], bus.cost);

            for (Bus newBus : busList[bus.end]) {
                dist[newBus.start][newBus.end] = Math.min(dist[newBus.start][newBus.end], bus.cost + newBus.cost);
                queue.add(newBus);
            }
        }

        int min = MAX;
        for (int i=1; i<dist.length; i++) {
            min = Math.min(dist[i][end], min);
        }

        return min;
    }


    static class Bus {
        Integer start;
        Integer end;
        int cost;

        public Bus(Integer start, Integer end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
