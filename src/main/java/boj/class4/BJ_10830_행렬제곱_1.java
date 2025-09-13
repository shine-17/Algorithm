package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10830_행렬제곱_1 {
    static long[][] arr;
    static int n;
    static int b;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr = new long[n][n];

            for (int i=0; i<n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            }

            matrixMultiple(arr, arr, n);




        } catch (Exception ignored) {}
    }

    static void divide() {



    }

    static long[][] matrixMultiple(long[][] arr1, long[][] arr2, int n) {
        long[][] newArr = new long[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                long sum = 0;

                for (int k=0; k<n; k++) {
                    sum += arr1[i][k] * arr2[k][j] % 1000;
                }

                newArr[i][j] = sum;

                System.out.print(sum + " ");
            }
            System.out.println();
        }

        return newArr;
    }
}
