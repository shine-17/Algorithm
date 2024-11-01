package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1389_케빈베이컨의6단계법칙_1 {
    static int n;
    static List<Integer>[] users;
    static boolean[] visited;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            users = new ArrayList[n+1];
            for(int i=1; i<users.length; i++) {
                users[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!users[a].contains(b)) users[a].add(b);
                if(!users[b].contains(a)) users[b].add(a);
            }

            TreeMap<Integer, Integer> resultMap = new TreeMap<>();

            for(int i=1; i<users.length; i++) {
                int kevinBaconCount = kevinBacon(i);

                if(!resultMap.containsKey(kevinBaconCount)) resultMap.put(kevinBaconCount, i);
            }

            System.out.println(resultMap.firstEntry().getValue());

        } catch(Exception ignored) {}
    }

    static int kevinBacon(int user) {
        int kevinBaconCount = 0;

        for(int i=1; i<users.length; i++) {
            if(user == i) continue;

            visited = new boolean[n+1];

            kevinBaconCount += bfs(user, i);
        }

        return kevinBaconCount;
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] distance = new int[n+1];
        visited[start] = true;

        while(!queue.isEmpty()) {
            int user = queue.poll();

            for(Integer friend : users[user]) {
                if(!visited[friend]) {
                    distance[friend] = distance[user] + 1;

                    if(end == friend) return distance[end];

                    visited[friend] = true;
                    queue.add(friend);
                }
            }
        }

        return distance[end];
    }

}
