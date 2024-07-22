package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2749 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long num1 = 0;
		long num2 = 1;
		long sum = 1;
		long share = 1000000;
		
		for(int i=1; i<n; i++) {
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
		}
		
		System.out.println(sum % share);
	}

}
