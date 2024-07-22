package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BJ_10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> bjArr = new ArrayList<String>();
		
		for(int i=0; i<N; i++) {
			bjArr.add(br.readLine());
		}
		
		Collections.sort(bjArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Integer n1 = Integer.parseInt(o1.split(" ")[0]);
				Integer n2 = Integer.parseInt(o2.split(" ")[0]);
				
				return n1.compareTo(n2);
			}
			
		});
		
		for(String s : bjArr)
			System.out.println(s);
	}

}
