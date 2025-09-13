package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10870 {
	static int[] pbArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		pbArr = new int[n+1];
		//초기값 설정
		
		int num = pibonacci(n);
		System.out.println(num);
	}
	
	//메모이제이션 적용
	public static int pibonacci(int n) {
		if(n <= 1)
			pbArr[n] = n;
		else if(pbArr[n] == 0)
			pbArr[n] = pibonacci(n-1) + pibonacci(n-2);
			
		return pbArr[n];
	}
}
