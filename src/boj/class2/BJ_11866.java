package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> people = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++)
			people.add(i);
		
		int num = --K; //인덱스이기에 -1
		String output = "<";
		
		while(people.size() > 0) {
			if(num >= people.size())
				num%=people.size();
			
			output += people.get(num) + ", ";
			people.remove(num);
			
			num += K;
			
			if(num >= people.size())
				num-=people.size();
		}
		
		output = output.substring(0, output.length()-2) + ">";
		System.out.println(output);
	}
}
