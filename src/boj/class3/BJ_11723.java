package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_11723 {
    public static void main(String[] args) {

        // 16:11 start
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<Integer>();

        /*
            비어있는 공집합 S

            add x : S에 추가 (이미 있으면 무시)
            remove x : S에서 x를 제거 (없으면 무시)
            check x : S에 x가 있으면 1을, 없으면 0 [출력]
            toggle x : S에 x가 있으면 제거, 없으면 x를 추가
            all : S를 {1,2,3...20} 으로 바꾼다
            empty : S를 공집합으로 바꾼다
         */

        try {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();

                if(op == null || op.isBlank()) continue;

                Integer value = 0;
                if(!op.equals("all") && !op.equals("empty")) {
                    value = Integer.valueOf(st.nextToken());
                }



                switch (op) {
                    case "add":
                        set.add(value);
                        break;
                    case "remove":
                        set.remove(value);
                        break;
                    case "check":
                        if(set.contains(value)) System.out.println(1);
                        else System.out.println(0);
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
        } catch(Exception e) {}
    }
}
