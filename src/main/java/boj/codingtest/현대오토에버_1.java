package boj.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 현대오토에버_1 {
    static int[][] conveyorBelt;
    static int min = Integer.MAX_VALUE;
    static int n, m;

    static final int BLANK = 0;
    static final int DOWN = -1;
    static final int UP = 1;
    static final int FIX = 2;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            /*
                현대오토에버 1번 #구현 #완탐? #그리디?
                        세로가 n이고 가로는 1인 컨테이너 벨트가 있음
                컨테이너 벨트는 m개 -> nxm 2차원 배열 생각하면 됨
                칸에는 로봇팔이 있는데 로봇팔의 방향은 (위 or 아래) = (1, -1)
                처음 로봇팔의 방향을 알려주고 로봇팔은 방향대로 이동함
                로봇팔의 위치가 맨끝 혹은 맨 아래일경우 방향전환해야함
                로봇팔의 입력값은 (로봇팔의 위치, 방향) 으로 주어진다
                버튼을 사용해서 로봇팔을 고정을 하려는데 모든 로봇팔을 하나의 행에 고정해야함
                하나의 행에 고정하는데 최소로 걸리는 시간을 구하라

                세로 n = 4 m=5
                로봇팔 입력값
                {{1,1}, {2,1}, {4,-1}, {3,-1}, {3,1}}
                답은 5

                세로 n=6 m=2
                로봇팔 입력값
                {{1,1},{1,1}}
                답은 6

4 5
1 1
2 1
4 -1
3 -1
3 1


6 2
1 1
1 1

            */

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 세로
            m = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 가로

            conveyorBelt = new int[n][m];

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()); // 로봇팔 위치(행)
                int y = Integer.parseInt(st.nextToken()); // 로봇팔 방향(1: 아래, -1: 위)

                conveyorBelt[x-1][i] = y;
            }

            for (int i=0; i<n; i++) {
                fix(i);
            }

            System.out.println(min);

        } catch (Exception ignored) {}
    }

    static void print(int[][] copyArr) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(copyArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void fix(int x) {
        int fixCount = 0;
        int time = 0;

        int[][] copyArr = copy();

        while (fixCount < m) {
            move(copyArr);
            time++;

            for (int i=0; i<m; i++) {
                if (copyArr[x][i] == UP || copyArr[x][i] == DOWN) {
                    copyArr[x][i] = FIX;
                    fixCount++;
                    break;
                }
            }
        }

        min = Math.min(min, time);
    }

    static void move(int[][] copyArr) {
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                int robot = copyArr[i][j];

                if (robot == UP) {
                    if (i == n-1) copyArr[i-1][j] = DOWN;
                    else copyArr[i+1][j] = robot;
                    copyArr[i][j] = BLANK;
                    break;
                }
                else if (robot == DOWN) {
                    if (i == 0) copyArr[i+1][j] = UP;
                    else copyArr[i-1][j] = robot;
                    copyArr[i][j] = BLANK;
                    break;
                }
            }
        }
    }

    static int[][] copy() {
        int[][] copyArr = new int[n][m];
        for (int i=0; i<n; i++) {
            copyArr[i] = Arrays.copyOf(conveyorBelt[i], conveyorBelt[i].length);
        }

        return copyArr;
    }
}
