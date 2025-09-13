package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_30805_사전순최대공통부분수열_1 {
    static List<Integer> seqA;
    static List<Integer> seqB;
    static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            seqA = new ArrayList<>();
            String[] split = br.readLine().split(" ");
            for (int i=0; i<n; i++) {
                seqA.add(Integer.parseInt(split[i]));
            }

            int m = Integer.parseInt(br.readLine());
            seqB = new ArrayList<>();
            split = br.readLine().split(" ");
            for (int i=0; i<m; i++) {
                seqB.add(Integer.parseInt(split[i]));
            }

            findSequence();

            System.out.println(dp.size());
            dp.forEach(num -> {
                System.out.print(num + " ");
            });

        } catch (Exception ignored) {}
    }

    static void findSequence() {
        if (seqA.isEmpty() || seqB.isEmpty()) return;

        Integer maxA = seqA.stream().max(Integer::compare).orElse(0);
        Integer maxB = seqB.stream().max(Integer::compare).orElse(0);

        if (maxA.equals(maxB)) {
            dp.add(maxA);
            seqA = seqA.subList(seqA.indexOf(maxA) + 1, seqA.size());
            seqB = seqB.subList(seqB.indexOf(maxB) + 1, seqB.size());
        }
        else if (maxA > maxB) {
            seqA.remove(maxA);
        }
        else {
            seqB.remove(maxB);
        }

        findSequence();
    }
}
