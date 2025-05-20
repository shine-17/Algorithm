package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
    static int[][] ocean;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            /*
                아기 상어
                - 처음 크기 : 1
                - 1초에 상하좌우로 한 칸씩 이동
                - 자신의 크기보다 큰 물고기가 있는 칸을 제외하고 모두 이동 가능
                - 자신의 크기보다 작은 물고기만 먹을 수 있음

                - 더 이상 먹을 수 있는 물고기가 없으면 엄마 상어에게 도움 요청
                - 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
                - 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
                    - 거리는 최단거리다.
                    - 거리가 가까운 물고기가 많다면 우선순위는 가장 위에 있는 물고기 > 가장 왼쪽에 있는 물고기

                - 물고기를 먹으면 빈 칸이 된다.
                - 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
                    - ex) 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

                아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 사냥할 수 있는지

                0: 빈 칸
                1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
                9: 아기 상어의 위치
             */


            int n = Integer.parseInt(br.readLine());
            ocean = new int[n][n];
            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());



            }

        } catch (Exception ignored) {}
    }
}
