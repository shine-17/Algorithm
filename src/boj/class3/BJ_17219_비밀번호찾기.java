package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_17219_비밀번호찾기 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<String, String> map = new HashMap<>();

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }

            for(int i=0; i<m; i++) {
                String key = br.readLine();

                if(map.containsKey(key)) {
                    System.out.println(map.get(key));
                }
            }

        } catch(Exception ignored) {}
    }
}
