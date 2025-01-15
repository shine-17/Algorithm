package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2579_계단오르기 {
	private static int[] stairs;
	
	private static Integer[] dp;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
			
			int count = Integer.parseInt(br.readLine());
			
			stairs = new int[count + 1];
			dp = new Integer[count + 1];
			
			for(int i=1; i<stairs.length; i++) {
				stairs[i] = Integer.parseInt(br.readLine());
			}
			
			dp[0] = stairs[0];
			dp[1] = stairs[1];
			
			if(count >= 2) {
				dp[2] = stairs[1] + stairs[2];
			}
			
			System.out.println(find(count));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static int find(int i) {
		if(dp[i] == null) {
			dp[i] = Math.max(find(i-2), find(i-3) + stairs[i-1]) + stairs[i];
		}
		
		return dp[i];
	}

}
