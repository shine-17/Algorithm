package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> pockets = new HashMap<>();

        // 17:30 start
        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=0; i<n; i++) {
                String index = String.valueOf(i+1);
                String value = br.readLine();

                pockets.put(index, value);
                pockets.put(value, index);
            }

            for(int i=0; i<m; i++) {
                String pocketMon = br.readLine();
                System.out.println(pockets.get(pocketMon));
            }

        } catch(Exception e ) {}
    }
}
