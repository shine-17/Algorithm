package boj.class1;

import java.util.Scanner;

public class BJ_1330 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		String compare = null;
		
		if(a > b)
			compare = ">";
		else if(a < b)
			compare = "<";
		else if(a == b)
			compare = "==";
		
		System.out.println(compare);
	}

}
