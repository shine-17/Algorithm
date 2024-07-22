package boj.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2747 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//Top-Down 재귀
//		int num = fibonacci(n);
//		System.out.println(num);
		
	
	 	//Bottom-Up 반복문
		int a = 0;
		int b = 1;
		int sum = 1;
		
		for(int i=1; i<n; i++) {
			sum = a+b;
			a = b;
			b = sum;
		}
		System.out.println(sum);
		
	}
	
	public static int fibonacci(int n) {
		int[] fiboArr = new int[100];
		
		if(n <= 2)
			return 1;
		if(fiboArr[n] == 0)
			fiboArr[n] = fibonacci(n-1) + fibonacci(n-2);
		
		return fiboArr[n];
	}
}
