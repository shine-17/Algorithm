package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1916_최소비용구하기_1 {
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

        } catch (Exception ignored) {}
    }

    static int findMinimumCost(int n, int start, int end) {
        boolean[] visited = new boolean[n+1];

        PriorityQueue<Bus> queue = new PriorityQueue<>(busList[start]);
        int cost = 0;

        while (!queue.isEmpty()) {
            // 제일 비용이 저렴한 버스노선
            Bus bus = queue.poll();

            if (bus.end == end) {
                cost = bus.cost;
                break;
            }

            if (!visited[bus.end]) {
                visited[bus.end] = true;

                for (int i=0; i<busList[bus.end].size(); i++) {
                    Bus bus1 = busList[bus.end].get(i);
                    bus1.cost += bus.cost;
                }

                queue.addAll(busList[bus.end]);
            }
        }

        return cost;
    }


    static class Bus implements Comparable<Bus> {
        Integer start;
        Integer end;
        int cost;

        public Bus(Integer start, Integer end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }
}
