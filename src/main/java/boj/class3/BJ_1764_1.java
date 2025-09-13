package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1764_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            // 18:16 start
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Set<String> notHeard = new HashSet<>();
            Set<String> set = new TreeSet<>();

            for(int i=0; i<n; i++) {
                notHeard.add(br.readLine());
            }
            for(int i=0; i<m; i++) {
                String key = br.readLine();
                if(notHeard.contains(key)) set.add(key);
            }

            System.out.println(set.size());
            for(String s : set) {
                System.out.println(s);
            }
        } catch(Exception e) {}
    }
}
