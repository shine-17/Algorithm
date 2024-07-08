package class2;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1085 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int w = scan.nextInt();
		int h = scan.nextInt();
		
		int[] min = {Math.abs(w-x), Math.abs(h-y), Math.abs(x-0), Math.abs(y-0)};
		
		Arrays.sort(min);
		
		System.out.println(min[0]);
	}

}
