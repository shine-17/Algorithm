package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		int endNum = 666;
		
		while(count != n) {
			endNum++;
			
			if(String.valueOf(endNum).contains("666"))
				count++;
		}
		
		System.out.println(endNum);

	}

}
