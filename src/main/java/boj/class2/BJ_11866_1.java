package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_11866_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> arr = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			arr.add(i);
		}
		
		int idx = 0;
		String output = "<";
		
		while(arr.size() > 0) {
			
			for(int i=0; i<K-1; i++) {
				int num = arr.poll();
				arr.offer(num);
			}
			
			output += arr.poll() +", ";
		}
		
		output = output.substring(0, output.length()-2) + ">";
		System.out.println(output);
	}

}
