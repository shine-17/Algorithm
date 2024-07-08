package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class bj_2751_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			set.add(num);
		}

		for(int num : set)
			bw.write(num + "\n");
		
		br.close();
		bw.close();
	}

}
