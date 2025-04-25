package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕_1 {
    static int[][] homes;
    static int upAirPurifier;
    static int downAirPurifier;

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());   // 행
            int c = Integer.parseInt(st.nextToken());   // 열
            int t = Integer.parseInt(st.nextToken());   // 시간
            homes = new int[r][c];

            for (int i=0; i<r; i++) {
                String[] split = br.readLine().split(" ");

                for (int j=0; j<split.length; j++) {
                    int value = Integer.parseInt(split[j]);

                    homes[i][j] = value;

                    if (value == -1) {
                        if (upAirPurifier == 0) upAirPurifier = i;
                        else downAirPurifier = i;
                    }
                }
            }

            for (int i=0; i<t; i++) {
                spreadFineDust(r, c);
                airPurifier(r, c);
            }

            int sum = 0;

            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    sum += homes[i][j];
                }
            }

            System.out.println(sum + 2);

        } catch (Exception ignored) {}
    }

    static void spreadFineDust(int r, int c) {
        int[][] newHomes = new int[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                newHomes[i][j] += homes[i][j];

                if (newHomes[i][j] == -1) continue;

                for (int k=0; k<mx.length; k++) {
                    int nx = i + mx[k];
                    int ny = j + my[k];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && homes[nx][ny] != -1) {
                        newHomes[nx][ny] += homes[i][j] / 5;
                        newHomes[i][j] -= homes[i][j] / 5;
                    }
                }
            }
        }

        homes = newHomes;
    }

    static void airPurifier(int r, int c) {
        int[][] newHomes = new int[r][c];

        // 공기청정기 윗부분
        for (int i=0; i<=upAirPurifier; i++) {
            for (int j=0; j<c; j++) {
                int room = homes[i][j];

                // 왼쪽
                if (j == 0 && i < upAirPurifier) {
                    newHomes[i+1][j] = room;
                }
                else if (j == c-1) {
                    if (i == 0) newHomes[i][j-1] = room;
                    else newHomes[i-1][j] = room;
                }
                else if (i == 0) {
                    newHomes[i][j-1] = room;
                }
                else if (i == upAirPurifier) {
                    newHomes[i][j+1] = room;
                }
                else {
                    newHomes[i][j] = room;
                }
            }
        }

        // 공기청정기 아랫부분
        for (int i=downAirPurifier; i<r; i++) {
            for (int j=0; j<c; j++) {
                int room = homes[i][j];

                if (j == 0 && i > downAirPurifier) {
                    newHomes[i-1][j] = room;
                }
                else if (j == c-1) {
                    if (i == r-1) newHomes[i][j-1] = room;
                    else newHomes[i+1][j] = room;
                }
                else if (i == downAirPurifier) {
                    newHomes[i][j+1] = room;
                }
                else if (i == r-1) {
                    newHomes[i][j-1] = room;
                }
                else {
                    newHomes[i][j] = room;
                }
            }
        }

        // 공기 청정기로 정화된 곳
        newHomes[upAirPurifier][1] = 0;
        newHomes[downAirPurifier][1] = 0;
        newHomes[upAirPurifier][0] = -1;
        newHomes[downAirPurifier][0] = -1;

        homes = newHomes;
    }

}
