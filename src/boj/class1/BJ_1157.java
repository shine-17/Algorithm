package class1;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1157 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		str = str.toUpperCase();
		int[] alphabet = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<alphabet.length; j++) {
				if(str.charAt(i) - 65 == j) {
					alphabet[j]++;
				}
			}
		}
		
		int max = -1;
		int maxIndex=0;
		
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i] > max) {
				max = alphabet[i];
				maxIndex=i;
			}
		}
		
		Arrays.sort(alphabet);
		
		if(alphabet[alphabet.length-1] == alphabet[alphabet.length-2])
			System.out.println("?");
		else
			System.out.println((char)(maxIndex + 65));
		
	}

}
