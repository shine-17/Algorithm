package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_11723_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            // 공집합 S
            Set<Integer> set = new HashSet<>();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();

                int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

                switch (op) {
                    case "add":
                        set.add(value);
                        break;
                    case "remove":
                        set.remove(value);
                        break;
                    case "check":
                        sb.append(set.contains(value) ? 1 : 0).append("\n");
                        break;
                    case "toggle":
                        if(set.contains(value)) set.remove(value);
                        else set.add(value);
                        break;
                    case "all":
                        set.clear();
                        for(int j=1; j<=20; j++) {
                            set.add(j);
                        }
                        break;
                    case "empty":
                        set.clear();
                        break;
                }
            }

            System.out.println(sb);

        } catch(Exception e) {}
    }
}
