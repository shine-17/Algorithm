package boj.class2;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;

public class BJ_2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m=0;
		
		for(int i=0; i<n; i++) {
			//분해합
			m = i+1;
			String str = String.valueOf(m);
					
			for(int j=0; j<str.length(); j++) {
				m += str.charAt(j) - '0';
			}
			
			if(m == n)
				list.add(i+1);
		}
		
		Collections.sort(list);
		
		if(list.size() > 0)
			System.out.println(list.get(0));
		else
			System.out.println("0");
	}

}
