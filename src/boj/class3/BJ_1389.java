package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_1389 {
	static List<ArrayList<Integer>> friends = new ArrayList<ArrayList<Integer>>();
	static List<Boolean> visited = new ArrayList<Boolean>();
	static ArrayList<Integer> check = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			ArrayList<Integer> friend = new ArrayList<Integer>();
			friends.add(friend);
			visited.add(false);
			check.add(0);
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends.get(a-1).add(b);
			friends.get(b-1).add(a);
		}
		
		for(List<Integer> list : friends) {
			Collections.sort(list);
		}
		
		int min = Integer.MAX_VALUE;
		int result = 0;
		
		for(int i=1; i<=n; i++) {
			int sum = 0;
			
			for(int j=1; j<=n; j++) {
				if(i != j) {
					for(int k=0; k<n; k++) {
						visited.set(k, false);
						check.set(k, 0);
					}
					sum += bfs(i, j);
				}
			}
			
			if(sum < min) {
				result = i;
				min = Math.min(min, sum);
			}
		}
		
		System.out.println(result);
	}
	
	static int bfs(int n, int m) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited.set(n-1, true); // 노드방문여부 true
		queue.add(n);
		
		while(!queue.isEmpty()) {
			n = queue.poll();
			
			//방문한 노드와 인접한 모든 노드를 가져옴
			Iterator<Integer> i = friends.get(n-1).listIterator();
			while(i.hasNext()) {
				int node = i.next();
				
				//방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
				if(!visited.get(node-1)) {
					check.set(node-1, check.get(n-1)+1);
					
					if(node == m)
						return check.get(node-1);
					
					visited.set(node-1, true);
					queue.add(node);
				}
			}
		}
		
		return 0;
	}

}
