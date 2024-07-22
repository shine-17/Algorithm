package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //나무의 수
		int M = Integer.parseInt(st.nextToken()); //집으로 가져가는 나무의 길이
		ArrayList<Integer> treeList = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			treeList.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(treeList);
		
		int min = 0;
		int max = treeList.get(treeList.size()-1);

		while(min < max) {
			long sum = 0;
			int mid = (max + min) / 2;
			
			for(int tree : treeList) {
				if(tree > mid) {
					sum += tree - mid;
				}
			}
			
			if(M > sum) {
				max = mid;
			} else {
				min = mid+1;
			}
			
		}
		
		System.out.println(min-1);
		
	}

}
