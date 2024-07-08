package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> triangle = new ArrayList<Integer>();
			
			while(st.hasMoreTokens()) {
				triangle.add(Integer.parseInt(st.nextToken()));
			}
			
			if(triangle.get(0).toString().equals("0")) {
				break;
			}
			
			Collections.sort(triangle);
			
			int a = (int) Math.pow(triangle.get(0), 2);
			int b = (int) Math.pow(triangle.get(1), 2);
			int c = (int) Math.pow(triangle.get(2), 2);
			
			if(c == a+b) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}

	}
}
