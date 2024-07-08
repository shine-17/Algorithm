package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String p = getP(n);

            long start = System.currentTimeMillis();

            int count = getIncludedString(s, p);

//            System.out.println("p: " + p + ", count: " + count);
//            System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * KMP Algorithm
     */
    private static int getIncludedString(String text, String pattern) {
        int count = 0;
        int[] pi = new int[pattern.length()]; // 건너뛰기 표

        //건너뛰기 표(pi) 생성
        // ex) IOIOIA
        int idx=0;
        for(int i=1; i<pattern.length(); i++) {
            // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = pi[idx-1]; //idx=0; 같음, 왜 돌려주는지 이해가 안됨.
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                pi[i] = ++idx;
            }
        }

//        for(int i : pi) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");

        //검색
        idx = 0; // 현재 대응되는 글자 수

        for(int i=0; i<text.length(); i++) {
            // idx번 글자와 짚더미의 해당 글자가 불일치할 경우,
            // 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
            while(idx>0 && text.charAt(i) != pattern.charAt(idx)) {
                idx = pi[idx-1];
            }

            // 글자가 대응될 경우
            if(text.charAt(i) == pattern.charAt(idx)) {
                if(idx == pattern.length()-1) {
                    count++;
                    idx = pi[idx];
                } else {
                    idx++;
                }
            }
        }

        return count;
    }

    private static String getP(int n) {
        StringBuilder p = new StringBuilder("I");

        for (int i=0; i<n; i++) {
            p.append("OI");
        }

        return p.toString();
    }
}
