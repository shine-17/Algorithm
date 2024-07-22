package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); //가지고 있는 랜선의 개수
		int n = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수
		int[] lineArr = new int[k];
		
		for(int i=0; i<lineArr.length; i++) {
			lineArr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lineArr);
		
		long max = lineArr[lineArr.length-1];
		long min = 0;
		long mid = 0;
		
		max++;
		
		while(min < max) { //upper bound 이분탐색 상한
			long count = 0;
			mid = (max + min) / 2;
			
			for(int i=0; i<lineArr.length; i++) {
				count += lineArr[i]/mid;
			}
			
			if(count < n)  {
				max = mid;
			} else {
				min = mid+1;
			}
		}
				System.out.println(min-1);
		
	}

}
