package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 벨만-포드 알고리즘
// 한 정점에서만 시작해서 수행
public class BJ_1865_웜홀_3 {
    static ArrayList<Route>[] worlds;
    static final int INF = -1; // 음수 사이클 발생하는지 확인하기 위한 음수값

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int tc = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();

            for (int i=0; i<tc; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()); // 지점 수
                int m = Integer.parseInt(st.nextToken()); // 도로 개수
                int w = Integer.parseInt(st.nextToken()); // 웜홀 개수

                worlds = new ArrayList[n+1];
                int[] dist = new int[n+1];

                for (int j=0; j<=n; j++) {
                    worlds[j] = new ArrayList();
                }

                // 도로 (방향 없음), 웜홀 (방향 있음)
                for (int j=0; j<m + w; j++) {
                    st = new StringTokenizer(br.readLine());

                    int s = Integer.parseInt(st.nextToken()); // 연결 지점 번호
                    int e = Integer.parseInt(st.nextToken()); // 연결 지점 번호
                    int t = Integer.parseInt(st.nextToken()); // 걸리는 시간

                    if (j < m) {
                        worlds[s].add(new Route(e, t));
                        worlds[e].add(new Route(s, t));
                    }
                    else {
                        worlds[s].add(new Route(e, -t));
                    }
                }

                result.append(timeTravel(n, dist) ? "YES" : "NO").append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }


    static boolean timeTravel(int n, int[] dist) {
        Arrays.fill(dist, INF);
        dist[1] = 0;           // 시작 노드는 0으로 초기화 (시작 노드를 제외한 모든 노드를 INF로 초기화)

        // (정점의 개수 - 1)번 동안 최단거리 초기화
        for (int i=1; i<=n; i++) {

            // 최단거리 초기화
            for (Route route : worlds[i]) {
                if (dist[route.end] > dist[i] + route.time) {
                    dist[route.end] = dist[i] + route.time;

                    if (i == n) return true;
                }
            }
        }

        return false;
    }

    static class Route implements Comparable<Route> {
        int end;
        int time;

        public Route(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Route o) {
            return this.time - o.time;
        }
    }
}
