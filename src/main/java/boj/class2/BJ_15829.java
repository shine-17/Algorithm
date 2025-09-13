package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15829 {
	static final int m = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		long hash = 0;
		
		for(int i=0; i<str.length(); i++) {
			Integer idx = str.charAt(i) - 'a' + 1;
			hash += (idx * hash(i));
			
		}
		
		System.out.println(hash % m); // 추가
	}
	
	public static long hash(int n) { // 추가
		return n == 0 ? 1 : 31 * hash(n-1) % m;
	}
}
