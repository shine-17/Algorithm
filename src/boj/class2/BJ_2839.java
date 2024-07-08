package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int sum = N - (i*5) - (j*3);
				
				if(sum == 0 && i+j < count) {
					count = i+j;
				}
			}
		}
		
		if(count == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(count);
		}

	}

}
