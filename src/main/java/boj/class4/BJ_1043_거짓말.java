package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1043_거짓말 {
    static Set<Integer> visited = new HashSet<>();
    static ArrayList<Integer>[] partyList;
    static ArrayList<Integer>[] peopleList;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 사람 수
            int m = Integer.parseInt(st.nextToken()); // 파티 수

            partyList = new ArrayList[m]; // 파티 별로 참석한 사람들. partyList[1] = {1,2,3}
            peopleList = new ArrayList[n + 1]; // 사람들 별로 참석한 파티. peopleList[1] = {1,2,3}

            // 이야기의 진실을 아는 사람
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> truthList = new ArrayList<>();

            // 이야기의 진실을 아는 사람이 있을 때
            if (k > 0) {
                while(st.hasMoreTokens()) {
                    truthList.add(Integer.parseInt(st.nextToken()));
                }
            }

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                if (partyList[i] == null) partyList[i] = new ArrayList<>();

                int partyNum = Integer.parseInt(st.nextToken());
                while (st.hasMoreTokens()) {
                    int peopleNum = Integer.parseInt(st.nextToken());
                    partyList[i].add(peopleNum);

                    if (peopleList[peopleNum] == null) peopleList[peopleNum] = new ArrayList<>();
                    peopleList[peopleNum].add(i);
                }
            }

            // 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값
            for (Integer truth : truthList) {
                dfs(truth);
            }

            System.out.println(m - visited.size());

        } catch (Exception ignored) {}
    }

    static void dfs(int num) {
        if (peopleList[num] == null) return;

        for (Integer party : peopleList[num]) {
            if (visited.contains(party)) continue;

            visited.add(party);

            for (Integer partyPeople : partyList[party]) {
                dfs(partyPeople);
            }
        }
    }
}
