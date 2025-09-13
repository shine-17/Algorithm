package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1043_거짓말_1 {
    static List<Integer> truthPeople = new ArrayList<>();
    static List<Integer>[] people;
    static List<Integer>[] party;
    static Set<Integer> truthParty = new HashSet<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            people = new ArrayList[n+1];
            for (int i=0; i<people.length; i++) people[i] = new ArrayList<>();

            party = new ArrayList[m];
            for (int i=0; i<party.length; i++) party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for (int i=0; i<k; i++) {
                truthPeople.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());

                while (st.hasMoreTokens()) {
                    int peopleNum = Integer.parseInt(st.nextToken());
                    party[i].add(peopleNum);

                    people[peopleNum].add(i);
                }
            }

            for (Integer people : truthPeople) {
                attendParty(people);
            }

            System.out.println(m - truthParty.size());

        } catch (Exception ignored) {}
    }

    static void attendParty(int truthPeople) {
        for (Integer partyNum : people[truthPeople]) {

            if (truthParty.contains(partyNum)) continue;

            truthParty.add(partyNum);

            for (Integer partyPeople : party[partyNum]) {
                attendParty(partyPeople);
            }
        }

    }
}
