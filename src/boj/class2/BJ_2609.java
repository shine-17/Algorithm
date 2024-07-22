package boj.class2;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int LCM = 1; //최소공배수
		int GCF = 1; //최대공약수
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = a > b ? a : b;
		
		for(int i=1; i<=max; i++) {
			if(a % i == 0 && b % i == 0) {
				list.add(i);
			}
		}
		
		GCF = list.get(list.size()-1);
		LCM = GCF * (a / GCF) * (b / GCF);
		
		System.out.println(GCF);
		System.out.println(LCM);
		
	}

}
