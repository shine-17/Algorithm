package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//5 2
		
		int num = factorial(N) / (factorial(K) * factorial((N-K)));
		System.out.println(num);
	}
	
	public static int factorial(int n) {
		int factorial = 1;
		
		for(int i=1; i<=n; i++) {
			factorial *= i;
		}
		
		return factorial;
	}

}
