package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int day = a - b;
		int distance = v - a;
		int c = 0;
		
		if(a == v) {
			c = 1;
		} else if(day >= distance) {
			c = 2;
		} else if(distance % day > 0) {
			c = distance / day + 2;
		} else {
			c = distance / day + 1;
		}
		
		System.out.println(c);

	}

}
