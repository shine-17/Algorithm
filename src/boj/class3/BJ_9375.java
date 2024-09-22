package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_9375 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());
                Map<String, Integer> map = new HashMap<>();

                for(int j=0; j<n; j++) {
                    String costume = br.readLine().split(" ")[1];
                    map.put(costume, map.getOrDefault(costume, 0) + 1);
                }

                List<Integer> list = map.values().stream().sorted().toList();
                System.out.println(list);

                int sum = 0;
                for(int j=list.size()-1; j>=0; j--) {
                    int factorial = j != 0 ? j-1 : 0;
                    int current = list.get(j);

                    for(int k=0; k<factorial; k++) {
                        sum += current * list.get(k);
                    }
                }



//                if(map.size() > 1) {
//                    Integer total = map.values().stream().reduce(1, (a, b) -> a * b);
//                    n += total;
//                }
//
//                System.out.println(n);
//                System.out.println(map);
            }


            // n! / (r!( n-r)!)
            // 8! /


        } catch (Exception e) {}
    }
}
