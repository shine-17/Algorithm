package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_30804_과일탕후루 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            int[] fruits = new int[n];

            String[] split = br.readLine().split(" ");
            for(int i=0; i<split.length; i++) {
                int fruit = Integer.parseInt(split[i]);
                fruits[i] = fruit;
            }

            Map<Integer, Integer> fruitsMap = new HashMap<>();
            int left = 0; // left 포인터
            int maxLength = 0; // 과일이 2종류일 때 탕후루가 가장 긴 길이

            // right 포인터
            for(int right=0; right<n; right++) {

                fruitsMap.put(fruits[right], fruitsMap.getOrDefault(fruits[right], 0) + 1);

                // 과일의 종류는 2여야 함
                while(fruitsMap.size() > 2) {
                    fruitsMap.put(fruits[left], fruitsMap.get(fruits[left]) - 1);

                    if(fruitsMap.get(fruits[left]) == 0) {
                        fruitsMap.remove(fruits[left]);
                    }

                    left++;
                }
                maxLength = Math.max(maxLength, right - left + 1);
            }
            System.out.println(maxLength);

            /*
                10
                1 2 1 1 1 1 1 3 3 3

                right: 0, maxLength: 1
                    fruits = {1: 1}
                right: 1, maxLength: 2
                    fruits = {1: 1}, {2: 1}
                right: 2, maxLength: 3
                    fruits = {1: 2}, {2: 1}
                right: 3, maxLength: 4
                    fruits = {1: 3}, {2: 1}
                right: 4, maxLength: 5
                    fruits = {1: 4}, {2: 1}
                right: 5, maxLength: 6
                    fruits = {1: 5}, {2: 1}
                right: 6, maxLength: 7
                    fruits = {1: 6}, {2: 1}
                right: 7, maxLength: 6
                    fruits = {1: 6}, {2: 1}, {3: 1}
                    - left:0 -> {1: 5}, {2: 1}, {3: 1}
                    - left:1 -> {1: 5}, {2: 0}, {3: 1} -> - {1: 5}, {3: 1}
                    - left:2
                right: 8, maxLength: 7
                    fruits = {1: 5}, {3: 2}
                right: 9, maxLength: 8
                    fruits = {1: 5}, {3: 3}

10
3 3 3 1 1 1 1 1 2 1

                right: 0, maxLength: 1
                    fruits = {3: 1}
                right: 1, maxLength: 2
                    fruits = {3: 2}
                right: 2, maxLength: 3
                    fruits = {3: 3}
                right: 3, maxLength: 4
                    fruits = {1: 1}, {3: 3}
                right: 4, maxLength: 5
                    fruits = {1: 2}, {3: 3}
                right: 5, maxLength: 6
                    fruits = {1: 3}, {3: 3}
                right: 6, maxLength: 7
                    fruits = {1: 4}, {3: 3}
                right: 7, maxLength: 8
                    fruits = {1: 5}, {3: 3}
                right: 8, maxLength: 8
                    fruits = {1: 5}, {2: 1}, {3: 3}
                    - left: 0 -> {1: 5}, {2: 1}, {3: 2}
                    - left: 1 -> {1: 5}, {2: 1}, {3: 1}
                    - left: 2 -> {1: 5}, {2: 1}
                    - left: 3
                right: 9, maxLength: 8
                    fruits = {1: 6}, {2: 1}
             */


        } catch(Exception ignored) {}
    }
}
