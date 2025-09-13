package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=m; i<=n; i++) {
			if(i == 1)
				continue;
			
			int share = (int)Math.sqrt(i);
			int count = 0;
			
			for(int j=2; j<=share; j++) {
				if(i % j == 0) {
					count++;
					break;
				}
			}
			
			if(count == 0)
				System.out.println(i);
			
//			if((Math.sqrt(i)-share) != 0) {
//				if(i > 7) {
//					for(int j=0; j<arr.length; j++) {
//						if(i % arr[j] == 0) {
//							count++;
//							break;
//						}
//					}
//					if(count == 0) {
//						a++;
//						System.out.println(i);
//					}
//				} else {
//					for(int j=0; j<arr.length; j++) {
//						if(i == arr[j]) {
//							a++;
//							System.out.println(i);
//						}
//					}
//				}
//			}
		}

	}
}
