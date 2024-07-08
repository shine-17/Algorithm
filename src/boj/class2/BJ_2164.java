package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bj_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> cardList = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			cardList.add(i);
		}
		
		/**
		 * 검색
		 * ArrayList 시간복잡도 : O(1)
		 * LinkedList 시간복잡도 : O(n)
		 * ArrayList > LinkedList
		 * 
		 * 추가,삭제
		 * ArrayList 시간복잡도 : O(n)
		 * LinkedList 시간복잡도 : O(1)
		 * ArrayList < LinkedList
		 * 
		 */
		
		while(cardList.size() > 1) {
			cardList.remove(0); //바닥에 버리는 카드
			int top = cardList.get(0);
			cardList.remove(0); //밑으로 옮기는 카드
			cardList.add(top);
		}
		
		System.out.println(cardList.get(0));

	}

}

