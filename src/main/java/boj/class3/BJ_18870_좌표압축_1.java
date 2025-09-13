package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18870_좌표압축_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            int[] coordinateArr = new int[n];
            Set<Integer> coordinateSet = new TreeSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while(st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                coordinateArr[index++] = token;
                coordinateSet.add(token);
            }

            Map<Integer, Integer> coordinateMap = new HashMap<>();
            index= 0;
            for(Integer coordinate : coordinateSet) {
                coordinateMap.put(coordinate, index++);
            }

            StringBuilder sb = new StringBuilder();
            for(int coordinate : coordinateArr) {
                sb.append(coordinateMap.get(coordinate)).append(" ");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }
}
