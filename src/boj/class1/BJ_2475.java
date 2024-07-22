package boj.class1;

import java.util.Scanner;

public class BJ_2475 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			int num = scan.nextInt();
			sum += Math.pow(num, 2);
		}
		
		System.out.println(sum % 10);
	}

}
