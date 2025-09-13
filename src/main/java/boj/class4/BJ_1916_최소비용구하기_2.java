package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1916_최소비용구하기_2 {
    static List<Bus>[] buses;
    static final int INF = 100000000;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            buses = new ArrayList[n+1];

            for (int i=0; i<buses.length; i++) {
                buses[i] = new ArrayList<>();
            }

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                Bus bus = new Bus(end, cost);
                buses[start].add(bus);
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int minimumCost = findMinimumCost(start, end, n);
            System.out.println(minimumCost);

        } catch (Exception ignored) {}
    }

    static int findMinimumCost(int start, int end, int n) {
        PriorityQueue<Bus> queue = new PriorityQueue<>(buses[start]);

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Bus bus = queue.poll();

            if (bus.end == end) {
                return bus.cost;
            }

            for (Bus newBus : buses[bus.end]) {
                if (dist[newBus.end] > newBus.cost + bus.cost) {
                    dist[newBus.end] = newBus.cost + bus.cost;
                    newBus.cost += bus.cost;
                    queue.add(newBus);
                }
            }
        }

        return 0;
    }

    static class Bus implements Comparable<Bus> {
        int end;
        int cost;

        public Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return cost - o.cost;
        }
    }
}
