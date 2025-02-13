package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기 {
	static Integer[] dp; //메모이제이션 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer[n+1];
		dp[0] = dp[1] = 0; // 메모이제이션 초기화

//		for (int i=2; i<=n; i++) {
//			if (i % 6 == 0) dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), dp[i-1]) + 1;
//			else if (i % 3 == 0) dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
//			else if (i % 2 == 0) dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
//			else dp[i] = dp[i-1] + 1;
//		}
		
		int num = recur(n);
		System.out.println(num);
	}

	
	public static int recur(int n) {
		if(dp[n] == null) {
			if(n % 6 == 0) {
				dp[n] = Math.min(Math.min(recur(n/3), recur(n/2)), recur(n-1)) + 1;
			} else if(n % 3 == 0) {
				dp[n] = Math.min(recur(n/3), recur(n-1)) + 1;
			} else if(n % 2 == 0 ) {
				dp[n] = Math.min(recur(n/2), recur(n-1)) + 1;
			} else {
				dp[n] = recur(n-1) + 1;
			}
		}
		
		return dp[n];
	}
}
