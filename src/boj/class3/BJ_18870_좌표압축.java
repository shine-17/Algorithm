package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18870_좌표압축 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {

            int n = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");

            Map<Integer, Integer> coordinateMap = new TreeMap<>();
            for(int i=0; i<split.length; i++) {
                coordinateMap.put(i, Integer.parseInt(split[i]));
            }

            List<Integer> coordinateList = new ArrayList<>(coordinateMap.values());
            Collections.sort(coordinateList);

            // -10 -9 2 4 4
            int num = Integer.MIN_VALUE;
            int i = 0;

            Map<Integer, Integer> indexMap = new HashMap<>();
            for(Integer coordinate : coordinateList) {
                if(num != coordinate) {
                    indexMap.put(coordinate, i);
                    i++;
                    num = coordinate;
                }
            }

            Set<Integer> coordinateKeys = coordinateMap.keySet();
            for(Integer key : coordinateKeys) {
                int indexKey = coordinateMap.get(key);
                int value = indexMap.get(indexKey);

                sb.append(value).append(" ");
            }

            System.out.println(sb);

        } catch(Exception ignored) {}
    }
}
