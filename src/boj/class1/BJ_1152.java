package class1;

import java.util.Scanner;

public class bj_1152 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine().trim();
		String[] strArr = str.split(" ");
		
		if(str.equals(""))
			System.out.println(0);
		else
			System.out.println(strArr.length);
	}

}
