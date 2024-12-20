package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {
    static int[][] polyomino;
    static int n;
    static int m;
    static final int N_MIN = -1000;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            polyomino = new int[n][m];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<m; j++) {
                    polyomino[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(findMaxTetromino());


        } catch (Exception ignored) {}
    }

    static int findMaxTetromino() {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                max = Math.max(max, tetromino1(i, j));
                max = Math.max(max, tetromino2(i, j));
                max = Math.max(max, tetromino3(i, j));
                max = Math.max(max, tetromino4(i, j));
                max = Math.max(max, tetromino5(i, j));
            }
        }

        return max;
    }

    // ────
    static int tetromino1(int x, int y) {
        int[] sum = new int[4];

        for(int i=0; i<4; i++) {
            sum[0] += x+i < n ? polyomino[x+i][y] : N_MIN;
            sum[1] += x-i >= 0 ? polyomino[x-i][y] : N_MIN;
            sum[2] += y+i < m ? polyomino[x][y+i] : N_MIN;
            sum[3] += y-i >= 0 ? polyomino[x][y-i] : N_MIN;
        }

        return Arrays.stream(sum).max().getAsInt();
    }

    // ㅁ
    static int tetromino2(int x, int y) {
        int[] sum = new int[4];

        for(int i=0; i<2; i++) {
            sum[0] += x+i < n ? polyomino[x+i][y] : N_MIN;
            sum[1] += x-i >= 0 ? polyomino[x-i][y] : N_MIN;
            sum[2] += y+i < m ? polyomino[x][y+i] : N_MIN;
            sum[3] += y-i >= 0 ? polyomino[x][y-i] : N_MIN;
        }

        for(int i=0; i<2; i++) {
            sum[0] += y-1 >= 0 && x+i < n ? polyomino[x+i][y-1] : N_MIN;
            sum[1] += y-1 >= 0 && x-i >= 0 ? polyomino[x-i][y-1] : N_MIN;
            sum[2] += x+1 < n && y+i < m ? polyomino[x+1][y+i] : N_MIN;
            sum[3] += x+1 < n && y-i >= 0 ? polyomino[x+1][y-i] : N_MIN;
        }

        return Arrays.stream(sum).max().getAsInt();
    }

    // └──
    static int tetromino3(int x, int y) {
        int[] sum = new int[4];

        for(int i=0; i<3; i++) {
            sum[0] += x+i < n ? polyomino[x+i][y] : N_MIN;
            sum[1] += x-i >= 0 ? polyomino[x-i][y] : N_MIN;
            sum[2] += y+i < m ? polyomino[x][y+i] : N_MIN;
            sum[3] += y-i >= 0 ? polyomino[x][y-i] : N_MIN;

            if(i == 2) {
                sum[0] += x+i < n ? Math.max(y+1 < m ? polyomino[x+i][y+1] : N_MIN, y-1 >= 0 ? polyomino[x+i][y-1] : N_MIN) : N_MIN;
                sum[1] += x-i >= 0 ? Math.max(y+1 < m ? polyomino[x-i][y+1] : N_MIN, y-1 >= 0 ? polyomino[x-i][y-1] : N_MIN) : N_MIN;
                sum[2] += y+i < m ? Math.max(x+1 < n ? polyomino[x+1][y+i] : N_MIN, x-1 >= 0 ? polyomino[x-1][y+i] : N_MIN) : N_MIN;
                sum[3] += y-i >= 0 ? Math.max(x+1 < n ? polyomino[x+1][y-i] : N_MIN, x-1 >= 0 ? polyomino[x-1][y-i] : N_MIN) : N_MIN;
            }
        }

        return Arrays.stream(sum).max().getAsInt();
    }

    // ┗┓
    static int tetromino4(int x, int y) {
        int[] sum = new int[4];

        for(int i=0; i<2; i++) {
            sum[0] += x+i < n ? polyomino[x+i][y] : N_MIN;
            sum[1] += x-i >= 0 ? polyomino[x-i][y] : N_MIN;
            sum[2] += y+i < m ? polyomino[x][y+i] : N_MIN;
            sum[3] += y-i >= 0 ? polyomino[x][y-i] : N_MIN;

            if(i == 1) {
                if(x+i < n) {
                    int a = (y+1 < m ? polyomino[x+i][y+1] : N_MIN) + (y+1 < m && x+2 < n ? polyomino[x+2][y+1] : N_MIN);
                    int b = (y-1 >= 0 ? polyomino[x+i][y-1] : N_MIN) + (y-1 >= 0 && x+2 < n ? polyomino[x+2][y-1] : N_MIN);
                    sum[0] += Math.max(a, b);
                }
                if(x-i >= 0) {
                    int a = (y+1 < m ? polyomino[x-i][y+1] : N_MIN) + (y+1 < m && x-2 >= 0 ? polyomino[x-2][y+1] : N_MIN);
                    int b = (y-1 >= 0 ? polyomino[x-i][y-1] : N_MIN) + (y-1 >= 0 && x-2 >= 0 ? polyomino[x-2][y-1] : N_MIN);
                    sum[1] += Math.max(a, b);
                }
                if(y+i < m) {
                    int a = (x+1 < n ? polyomino[x+1][y+i] : N_MIN) + (x+1 < n && y+2 < m ? polyomino[x+1][y+2] : N_MIN);
                    int b = (x-1 >= 0 ? polyomino[x-1][y+i] : N_MIN) + (x-1 >= 0 && y+2 < m ? polyomino[x-1][y+2] : N_MIN);
                    sum[2] += Math.max(a, b);
                }
                if(y-i >= 0) {
                    int a = (x+1 < n ? polyomino[x+1][y-i] : N_MIN) + (x+1 < n && y-2 >= 0 ? polyomino[x+1][y-2] : N_MIN);
                    int b = (x-1 >= 0 ? polyomino[x-1][y-i] : N_MIN) + (x-1 >= 0 && y-2 >= 0 ? polyomino[x-1][y-2] : N_MIN);
                    sum[3] += Math.max(a, b);
                }
            }
        }

        return Arrays.stream(sum).max().getAsInt();
    }

    // ㅜ
    static int tetromino5(int x, int y) {
        int[] sum = new int[4];

        for(int i=0; i<3; i++) {
            sum[0] += x+i < n ? polyomino[x+i][y] : N_MIN;
            sum[1] += x-i >= 0 ? polyomino[x-i][y] : N_MIN;
            sum[2] += y+i < m ? polyomino[x][y+i] : N_MIN;
            sum[3] += y-i >= 0 ? polyomino[x][y-i] : N_MIN;

            if(i == 1) {
                sum[0] += x+i < n ? Math.max(y+1 < m ? polyomino[x+i][y+1] : N_MIN, y-1 >= 0 ? polyomino[x+i][y-1] : N_MIN) : N_MIN;
                sum[1] += x-i >= 0 ? Math.max(y+1 < m ? polyomino[x-i][y+1] : N_MIN, y-1 >= 0 ? polyomino[x-i][y-1] : N_MIN) : N_MIN;
                sum[2] += y+i < m ? Math.max(x+1 < n ? polyomino[x+1][y+i] : N_MIN, x-1 >= 0 ? polyomino[x-1][y+i] : N_MIN) : N_MIN;
                sum[3] += y-i >= 0 ? Math.max(x+1 < n ? polyomino[x+1][y-i] : N_MIN, x-1 >= 0 ? polyomino[x-1][y-i] : N_MIN) : N_MIN;
            }
        }

        return Arrays.stream(sum).max().getAsInt();
    }
}
