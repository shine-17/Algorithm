package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> nMap = new HashMap<Integer, Integer>();
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			if(nMap.get(num) != null) {
				nMap.put(num, nMap.get(num)+1);
			} else {
				nMap.put(num, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			Integer numCard = null;
			
			if(nMap.get(num) != null)
				numCard = nMap.get(num);
			else
				numCard = 0;
			
			sb.append(numCard + " ");
		}
		
		String output = sb.substring(0, sb.length()-1);
		System.out.println(output);
	}
}
