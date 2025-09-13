package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 벨만-포드 알고리즘
// 모든 정점에서 시작해서 음수 사이클을 체크하는 방법
public class BJ_1865_웜홀_2 {
    static ArrayList<Route>[] worlds;
    static final int INF = 2500 * 10000; // 25,000,000

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


                boolean isReturn = false;
                for (int j=1; j<=n; j++) {
                    isReturn = timeTravel(j, n, dist);

                    if (isReturn) break;
                }
                result.append(isReturn ? "YES" : "NO").append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }


    static boolean timeTravel(int start, int n, int[] dist) {
        Arrays.fill(dist, INF);
        dist[start] = 0;           // 시작 노드는 0으로 초기화 (시작 노드를 제외한 모든 노드를 INF로 초기화)

        // (정점의 개수 - 1)번 동안 최단거리 초기화
        for (int i=1; i<=n; i++) {
            // 최단거리 초기화
            for (int j=1; j<=n; j++) {
                for (Route route : worlds[j]) {
                    if (dist[j] != INF && dist[route.end] > dist[j] + route.time) {
                        dist[route.end] = dist[j] + route.time;

                        if (i == n) return true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 발생하지 않으면 종료
//            if (!update) break;
        }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우, (정점의 개수)번도 업데이트 발생하면 음수 사이클이 발생하는 것을 의미함
        // 같은 간선을 n-1번 돌리는데도 계속 업데이트(최단거리 갱신)가 됐다는 뜻이므로 음수 사이클이 발생했다고 볼 수 있음
//        if (update) {
//            for (int i=1; i<=n; i++) {
//                for (Route route : worlds[i]) {
//                    if (dist[i] != INF && dist[route.end] > dist[i] + route.time) return true;
//                }
//            }
//        }

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
