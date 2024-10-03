package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11399 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            int count = 0;
            int size = list.size();

            for(Integer i : list) {
                count += (i * size);
                size--;
            }

            System.out.println(count);

        } catch (Exception ignored) {}
    }
}
