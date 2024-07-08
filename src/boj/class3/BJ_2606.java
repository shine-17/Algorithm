package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class bj_2606 {
	
	private static List<List<Integer>> network = new ArrayList<List<Integer>>();
	
	private static LinkedHashSet<Integer> virusSet = new LinkedHashSet<Integer>();
	
	private static boolean[] DP;
	
	public static void main(String[] args) {
		
		try {
			Reader reader = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(reader);
			
			int comCount = Integer.parseInt(br.readLine());
			int pairCount = Integer.parseInt(br.readLine());
			
			DP = new boolean[comCount + 1];
			
			for(int i=0; i<comCount + 1; i++) {
				network.add(new ArrayList<Integer>());
			}
			
			StringTokenizer st = null;
			
			for(int i=0; i<pairCount; i++) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				if(!network.get(index).contains(value)) network.get(index).add(value);
				if(!network.get(value).contains(index)) network.get(value).add(index);
			}
			
//			for(List<Integer> list : network)
//				System.out.println(list);
			
			findNetwork(1);
			
			if(virusSet.contains(1)) virusSet.remove(1);
			System.out.println(virusSet.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findNetwork(int n) {
		DP[n] = true;
		
		for(Integer i : network.get(n)) {
			virusSet.add(i);
			
			if(DP[i]) continue;
			
			findNetwork(i);
		}
	}

}
