package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			cardList.add(num);
		}
		
		//내림차순 정렬
		Collections.sort(cardList, Collections.reverseOrder());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i=0; i<cardList.size()-2; i++) {
			for(int j=i+1; j<cardList.size()-1; j++) {
				for(int k=j+1; k<cardList.size(); k++) {
					sum = cardList.get(i) + cardList.get(j) + cardList.get(k);
					
					if(sum <= m && sum > max)
						max = sum;
				}
			}
		}
		
		System.out.println(max);
	}

}
