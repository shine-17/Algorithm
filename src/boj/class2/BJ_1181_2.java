package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class BJ_1181_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> wordArr = new ArrayList<String>();
		
		for(int i=0; i<n; i++)
			wordArr.add(br.readLine());
		
		HashSet<String> wordSet = new HashSet<String>(wordArr);
		wordArr.clear();
		wordArr.addAll(wordSet);
		
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		Collections.sort(wordArr, c);
		
		for(String s : wordArr)
			System.out.println(s);
		
	}

}
