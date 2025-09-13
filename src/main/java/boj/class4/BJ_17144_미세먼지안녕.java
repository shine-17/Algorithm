package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {
    static Room[][] homes;
    static Room upAirPurifier;
    static Room downAirPurifier;
    static ArrayDeque<Room> findDust;
    static ArrayDeque<Room> addFindDust;

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());   // 행
            int c = Integer.parseInt(st.nextToken());   // 열
            int t = Integer.parseInt(st.nextToken());   // 시간
            homes = new Room[r][c];
            findDust = new ArrayDeque<>();
            addFindDust = new ArrayDeque<>();

            for (int i=0; i<r; i++) {
                String[] split = br.readLine().split(" ");

                for (int j=0; j<split.length; j++) {
                    int value = Integer.parseInt(split[j]);
                    Room room = new Room(i, j, value);

                    homes[i][j] = room;

                    if (value == -1) {
                        if (upAirPurifier == null) upAirPurifier = room;
                        else downAirPurifier = room;
                    }
                }
            }

            for (int i=0; i<t; i++) {
                spreadFineDust(r, c);
                print(r, c);

                airPurifier(r, c);
                print(r, c);
                findDust.clear();
            }

            int sum = 0;

            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    sum += homes[i][j].count;
                }
            }

            System.out.println(sum + 2);

        } catch (Exception ignored) {}
    }

    static void print(int r, int c) {
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(homes[i][j].count + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    static void spreadFineDust(int r, int c) {
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                Room room = homes[i][j];

                if (room.count == -1) continue;

                findDust.add(room);

                int adjCount = 0;

                for (int k=0; k<mx.length; k++) {
                    int nx = room.x + mx[k];
                    int ny = room.y + my[k];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        Room adjRoom = homes[nx][ny];

                        // 미세먼지 확산
                        adjRoom.addCount += room.count / 5;
                        // 인접 노드 개수 카운팅
                        adjCount++;

                        if (adjRoom.addCount > 0) addFindDust.add(adjRoom);
                    }

                    room.adjCount = adjCount;
                }
            }
        }

        // 미세먼지 목록에 새로 확산된 미세먼지 추가
        for (Room room : addFindDust) {
            if (!findDust.contains(room)) findDust.add(room);
        }
        addFindDust.clear();

        // 미세먼지 확산 후 개수 갱신
        updateFindDustCount();
    }

    static void updateFindDustCount() {
        for (Room room : findDust) {
            room.count -= (room.count / 5 * room.adjCount);
            room.count += room.addCount;
            room.addCount = 0;
        }
    }

    static void airPurifier(int r, int c) {
        // 공기청정기 윗부분
        for (int i=0; i<=upAirPurifier.x; i++) {
            for (int j=0; j<c; j++) {
                Room room = homes[i][j];

                // 왼쪽
                if (j == 0 && i < upAirPurifier.x) {
                    if (homes[i+1][j].changeCount == -1) findDust.remove(homes[i+1][j]);
                    else homes[i+1][j].changeCount = room.count;
                }
                else if (j == c-1) {
                    if (i == 0) homes[i][j-1].changeCount = room.count;
                    else homes[i-1][j].changeCount = room.count;
                }
                else if (i == 0) {
                    homes[i][j-1].changeCount = room.count;
                }
                else if (i == upAirPurifier.x) {
                    homes[i][j+1].changeCount = room.count;
                }
                else {
                    room.changeCount = room.count;
                }
            }
        }

        // 공기청정기 아랫부분
        for (int i=downAirPurifier.x; i<r; i++) {
            for (int j=0; j<c; j++) {
                Room room = homes[i][j];

                if (j == 0 && i > downAirPurifier.x) {
                    if (homes[i-1][j].changeCount == -1) findDust.remove(homes[i - 1][j]);
                    else homes[i-1][j].changeCount = room.count;
                }
                else if (j == c-1) {
                    if (i == r-1) homes[i][j-1].changeCount = room.count;
                    else homes[i+1][j].changeCount = room.count;
                }
                else if (i == downAirPurifier.x) {
                    homes[i][j+1].changeCount = room.count;
                }
                else if (i == r-1) {
                    homes[i][j-1].changeCount = room.count;
                }
                else {
                    room.changeCount = room.count;
                }
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                Room room = homes[i][j];

                room.count = room.changeCount;
            }
        }

        // 공기 청정기로 정화된 곳
//        findDust.remove(homes[upAirPurifier.x][1]);
//        findDust.remove(homes[downAirPurifier.x][1]);
        homes[upAirPurifier.x][1].count = 0;
        homes[downAirPurifier.x][1].count = 0;

        upAirPurifier.count = -1;
        downAirPurifier.count = -1;
    }

    static class Room {
        int x;
        int y;
        int count;          // 미세먼지
        int addCount;       // 확산되어 더해질 미세먼지
        int adjCount;       // 인접노드 개수

        int changeCount;

        public Room(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
