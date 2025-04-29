package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_30805_사전순최대공통부분수열 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            List<Integer> seqA = new ArrayList<>();
            String[] split = br.readLine().split(" ");
            for (int i=0; i<n; i++) {
                seqA.add(Integer.parseInt(split[i]));
            }

            int m = Integer.parseInt(br.readLine());
            List<Integer> seqB = new ArrayList<>();
            split = br.readLine().split(" ");
            for (int i=0; i<m; i++) {
                seqB.add(Integer.parseInt(split[i]));
            }

            // 1. 점화식을 진행하면서 사전 순 최대 공통 부분 수열 구하기
            List<Integer> dp = new ArrayList<>();
            int max = Math.max(seqA.stream().max(Integer::compare).orElse(0), seqB.stream().max(Integer::compare).orElse(0));

            for (int i=max; i>0; i--) {

                while (seqA.contains(i) && seqB.contains(i)) {
                    dp.add(i);
                    // i(max) 의 인덱스가 3이었으면 4~
                    seqA = seqA.subList(seqA.indexOf(i) + 1, seqA.size());
                    seqB = seqB.subList(seqB.indexOf(i) + 1, seqB.size());
                }
            }

            System.out.println(dp.size());
            dp.forEach(num -> System.out.print(num + " "));

        } catch (Exception ignored) {}
    }
}
