package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		int range = 1;
		int i = 0;
		
		if(n != 1) {
			while(true) {
				i++;
				count++;
				range += (6 * i);
				
				if(n <= range) {
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
