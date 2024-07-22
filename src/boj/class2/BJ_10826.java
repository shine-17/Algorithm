package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_10826 {
	static BigInteger[] pbArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		pbArr = new BigInteger[n+1];
		
//		BigInteger num = pibonacci(n);
//		System.out.println(num);
		
		BigInteger p1 = new BigInteger("0");
		BigInteger p2 = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		
		for(int i=1; i<n; i++) {
			sum = p1.add(p2);
			p1 = p2;
			p2 = sum;
		}
		
		if(n == 0)
			System.out.println(0);
		else
			System.out.println(sum);
	}
	
	//메모이제이션
	private static BigInteger pibonacci(int n) {
		if(n <= 1)
			pbArr[n] = BigInteger.valueOf(n);
		else if(pbArr[n] == null)
			pbArr[n] = pibonacci(n-1).add(pibonacci(n-2));
		
		return pbArr[n];
	}

}
