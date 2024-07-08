package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class bj_4150 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger num1 = new BigInteger("0");
		BigInteger num2 = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		
		/*
		for(int i=1; i<n; i++) {
			sum = num1.add(num2);
			num1 = num2;
			num2 = sum;
		}
		
		System.out.println(sum);
		*/
		
		
		//메모이제이션 추가
		list = new BigInteger[n+1];
		
		list[0] = new BigInteger("0");
		list[1] = new BigInteger("1");
		BigInteger num = fibonacci(n);
		System.out.println(num);
	}
	
	static BigInteger[] list;
	
	public static BigInteger fibonacci(int n) {
		if(list[n] == null) {
			list[n] = fibonacci(n-1).add(fibonacci(n-2));
		}
		
		return list[n];
	}
}
