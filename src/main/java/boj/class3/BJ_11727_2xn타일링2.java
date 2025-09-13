package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_11727_2xn타일링2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            BigInteger a = new BigInteger("10007");
            BigInteger b = new BigInteger("2");
            BigInteger[] arr = new BigInteger[n+2];
            arr[1] = new BigInteger("1");
            arr[2] = new BigInteger("3");

            if(n > 2) {
                for(int i=3; i<=n; i++) {
                    arr[i] = arr[i-2].multiply(b).add(arr[i-1]);
                }
            }

            System.out.println(arr[n].remainder(a));


        } catch(Exception ignored) {}
    }
}
