package boj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2751_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list);
		
		for(int i : list)
			bw.write(i + "\n");
		
		br.close();
		bw.close();
	}
}
