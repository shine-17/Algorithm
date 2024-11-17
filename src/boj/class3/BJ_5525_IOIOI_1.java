package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_5525_IOIOI_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

//            String[] s = br.readLine().split("");
            String s = br.readLine();
            StringBuilder sb = new StringBuilder("I");
            sb.append("OI".repeat(Math.max(0, n)));

//            String[] p = sb.toString().split("");
            String p = sb.toString();

            int result = 0;
            int count = 0;
            for(int i=1; i<m-1;) {
//                System.out.println("index : " + i);

                if(s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                    count++;

                    if(count == n) {
                        if(s.charAt(i - (n*2-1)) == 'I') {
                            result++;
                        }

                        count--;
                    }

                    i += 2;
                }
                else {
                    i++;
                    count = 0;
                }
            }

            System.out.println(result);

        } catch(Exception ignored) {}
    }
}
