package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11047 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Integer> set = new TreeMap<>();

            for(int i=0; i<n; i++) {
                int num = Integer.parseInt(br.readLine());
                set.put(num, num);
            }

            int count = 0;
            while(k != 0) {
                Integer coin = set.containsKey(k) ? set.get(k) : set.lowerKey(k);

                if(coin == null) continue;

                count += k / coin;
                k %= coin;
            }

            System.out.println(count);

        } catch (Exception ignored) {}
    }
}
