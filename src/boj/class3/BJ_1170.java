package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_1170 {
	static List<Integer> numArr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 0 ~ 9 , + , -
		int n = Integer.parseInt(br.readLine()); //이동하려고 하는 채널
		int m = Integer.parseInt(br.readLine()); //고장난 버튼의 개수
		int channel = 100; //현재 채널 100번
		int count = 0;
		
		if(m > 0) { //고장난 버튼 있을 때
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				numArr.add(Integer.parseInt(st.nextToken()));
			
			int min = 0;
			int subtract = 1000001;
			
			// n에 가장 가까운 수 구하기
			for(int i=0; i<=1000000; i++) {
				String num = String.valueOf(i);
				boolean check = true;
				
				for(int j=0; j<num.length(); j++) {
					for(int k=0; k<numArr.size(); k++) {
						if(num.charAt(j) - '0' == numArr.get(k)) {
							check = false;
							break;
						}
					}
					
					if(check == false)
						break;
				}
				
				int abs = Math.abs(n-i);
				
				if(check && Math.abs(n - i) < subtract) {
//					System.out.println("min : " + i + " / " + Math.abs(n-i));
					subtract = Math.abs(n - i);
					min = i;
				}
			}
			
			if(n == 100) { //이동하려는 채널이 현재채널(100번)일 때
				count = 0;
			} else if(numArr.size() > 9) { //버튼 모두 고장났을 때
				count = Math.abs(n - channel);
			} else {
				count = Math.abs(n - min) + String.valueOf(min).length();
				
				if(Math.abs(n - channel) < count)
					count = Math.abs(n - channel); 
			}
			
			
		} else { //고장난 버튼 없을 때
			count = String.valueOf(n).length();
			
			if(Math.abs(n - channel) < count)
				count = Math.abs(n - channel);
		}
		
			/*
			 * 1. 고장난 버튼이 없어서 바로 될 때 
			 * 2. 고장난 버튼이 있을 때
			 * 2-1. 고장난 버튼 제외하고 채널보다 클 때
			 * 2-2. 고장난 버튼 제외하고 채널보다 작을 때
			 * 
			 * 
			 */
		
		System.out.println(count);
	}

}
