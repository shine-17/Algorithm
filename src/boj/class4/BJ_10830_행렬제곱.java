package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10830_행렬제곱 {
    static int n;
    static long[][] squareArr;
    static final int dividingNumber = 1000;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long[][] arr = new long[n][n];

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            squareArr = copyArr(arr);

            /*
                A * B * B * B * B * B...

                b = 5,
                2 * 2 * 1

                A^B % 1000 = (A % 1000) * (A % 1000) * (A % 1000) * (A % 1000) ... * B
             */

            long[][] newArr = divide(arr, b);

            StringBuilder result = new StringBuilder();

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    result.append(newArr[i][j]).append(" ");
                }
                result.append("\n");
            }

            System.out.println(result);


        } catch (Exception ignored) {}
    }

    static long[][] divide(long[][] arr, long b) {
        if (b == 1) return divideMatrix(arr);

        long[][] tempArr = divide(arr, b / 2);

        if (b % 2 == 1) {
            return divideMatrix(
                    matrixMultiple(
                            divideMatrix(matrixMultiple(tempArr, tempArr)), arr
                    )
            );
        }

        return divideMatrix(matrixMultiple(tempArr, tempArr));
    }

    static long[][] divideMatrix(long[][] arr) {
        long[][] temp = copyArr(arr);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                temp[i][j] %= dividingNumber;
            }
        }

        return temp;
    }

    static long[][] matrixMultiple(long[][] arr, long[][] arr2) {
        long[][] temp = new long[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                long sum = 0;

                for (int k=0; k<n; k++) {
                    sum += arr[i][k] * arr2[k][j];
                }

                temp[i][j] = sum;
            }
        }

        return temp;
    }

    static long[][] copyArr(long[][] arr) {
        long[][] temp = new long[n][n];

        for (int i=0; i<n; i++) {
            temp[i] = Arrays.copyOf(arr[i], n);
        }

        return temp;
    }
}
