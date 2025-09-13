package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003_피보나치함수 {
	static int[] pbArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		/*
		 * 피보나치
		 * 
		 * 재귀(Top-Down)
		 * 
		 * 반복문(Bottom-Up)
		 * 
		 */
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			pbArr = new int[n+1];
			
			System.out.println(fibonacci(n-1) + " " + fibonacci(n));
		}
	}

	public static int fibonacci(int n) {
		if(n < 0) {
			return 1;
		} else if(n <= 1) {
			pbArr[n] = n;
		} else if(pbArr[n] == 0) {
			pbArr[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		
		return pbArr[n];
	}
}
