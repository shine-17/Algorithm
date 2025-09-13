package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11723 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            비어있는 공집합 S

            add x : S에 추가 (이미 있으면 무시)
            remove x : S에서 x를 제거 (없으면 무시)
            check x : S에 x가 있으면 1을, 없으면 0 [출력]
            toggle x : S에 x가 있으면 제거, 없으면 x를 추가
            all : S를 {1,2,3...20} 으로 바꾼다
            empty : S를 공집합으로 바꾼다

            AND 연산 (&) : 대응하는 두 비트가 모두 1일 때 1 반환
            OR 연산 (|) : 대응하는 두 비트 중 하나라도 1이라면 1, 아니면 0 반환
            XOR 연산 (^) : 대응하는 두 비트가 다르면 1, 같으면 0을 반환
            NOT 연산 (~) : 비트의 값을 반전
            Shift 연산 (<<, >>) : 왼쪽 또는 오른쪽으로 비트를 이동
         */

//        int a = 0;
//        a = (1 << 10) - 1;

        // add 추가
//        a |= (1 << 1);

        // remove 삭제
//        a &= ~(1 << 1);

        // check 포함 여부 확인
//        System.out.println((a & (1 << 9)) == (1 << 9));

        // toggle 없으면 추가하고 있으면 삭제
//        a ^= (1 << 9);

        // all
//        a = (1 << 21) - 1;

//        1 0000 0000 0000 0000 0000
//        1 1111 1111 1111 1111 1111

        // empty
//        a = 0;


        try {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            // 공집합 S
            int set = 0;

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();

                if(op == null || op.isBlank()) continue;

                int value = 0;
                if(!op.equals("all") && !op.equals("empty")) {
                    value = Integer.parseInt(st.nextToken());
                }

                switch (op) {
                    case "add":
                        set |= (1 << value);
                        break;
                    case "remove":
                        set &= ~(1 << value);
                        break;
                    case "check":
                        sb.append((set & (1 << value)) != 0 ? 1 : 0).append("\n");
                        break;
                    case "toggle":
                        set ^= (1 << value);
                        break;
                    case "all":
                        // 1~20 의 수를 표현해야 되기때문에 21자리로 시트프 후 -1을 해서 20자리를 맞춤
                        set = (1 << 21) - 1;
                        break;
                    case "empty":
                        set = 0;
                        break;
                }
            }

            System.out.println(sb);

        } catch(Exception e) {}
    }
}
