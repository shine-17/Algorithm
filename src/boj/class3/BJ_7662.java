package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7662 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeMap<Integer, Integer> queue = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        try {
            int t = Integer.parseInt(br.readLine());

            for(int i=0; i<t; i++) {
                int k = Integer.parseInt(br.readLine());

                for(int j=0; j<k; j++) {
                    st = new StringTokenizer(br.readLine());

                    char op = st.nextToken().charAt(0);
                    int value = Integer.parseInt(st.nextToken());

                    if(op == 'I') {
                        queue.put(value, queue.getOrDefault(value, 0) + 1);
                    }
                    else if(op == 'D') {
                        if(queue.isEmpty()) continue;

                        int key = value == 1 ? queue.lastKey() : queue.firstKey();
                        int count = queue.get(key);

                        if(count == 1) {
                            queue.remove(key);
                        }
                        else {
                            queue.put(key, count - 1);
                        }
                    }
                }

                if(queue.isEmpty()) {
                    sb.append("EMPTY\n");
                }
                else {
                    sb.append(queue.lastKey() + " " + queue.firstKey() + "\n");
                }

                queue.clear();
            }

            System.out.println(sb.toString());

        } catch (Exception e) {}
    }
}

