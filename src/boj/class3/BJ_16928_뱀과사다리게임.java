package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16928_뱀과사다리게임 {
    static Map<Integer, Integer> ladderMap = new HashMap<>();
    static Map<Integer, Integer> snakeMap = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                ladderMap.put(x, y);
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                snakeMap.put(x, y);
            }

            int count = playBoard(1, 100);

            System.out.println(count);

        } catch(Exception ignored) {}
    }

    static int playBoard(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] distance = new int[110];

        while(!queue.isEmpty()) {
            int piece = queue.poll();

            if(piece == end) break;

            for(int i=1; i<=6; i++) {
                int newPiece = piece + i;

                // 7% : snakeMap을 queue에 넣어서 최단거리탐색에 방해됐음
                // 21% : 사다리든 뱀이든 무조건 타야함. 그 후로 주사위 굴릴 수 없음
                if(ladderMap.containsKey(newPiece)) {
                    newPiece = ladderMap.get(newPiece);
                }
                else if(snakeMap.containsKey(newPiece)) {
                    newPiece = snakeMap.get(newPiece);
                }

                if(distance[newPiece] == 0) {
                    queue.add(newPiece);
                    distance[newPiece] = distance[piece] + 1;
                }
            }
        }

        return distance[end];
    }
}
