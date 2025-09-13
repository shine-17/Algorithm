package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1541_잃어버린괄호_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String equation = br.readLine();

            /*
                55 50 40
                - +

                1-3+2-5+1

                1, 3+2, 5+1

             */

            List<Integer> sumArr = new ArrayList<>();
            String[] equations = equation.split("-");

            for(String str : equations) {
                if(str.contains("+")) {
                    String[] split = str.split("\\+");
                    int sum = 0;

                    for(String s : split) {
                        sum += Integer.parseInt(s);
                    }
                    sumArr.add(sum);
                }
                else {
                    sumArr.add(Integer.parseInt(str));
                }
            }

            int num = sumArr.get(0);
            for(int i=1; i<sumArr.size(); i++) {
                num -= sumArr.get(i);
            }

            System.out.println(num);

        } catch(Exception ignored) {}
    }
}
