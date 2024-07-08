package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_1697 {
	private static int n;
	private static int k;
	private static int time;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
			수빈이는 현재 점 N
			동생은 점 K
			
			걷거나 순간이동 가능
			
			X일 때
			걷기 : 1초 후 X-1 또는 X+1
			순간이동 : 1초 후 2*X
			
		*/
		
		n = Integer.parseInt(st.nextToken()); // 수빈이의 위치 N
		k = Integer.parseInt(st.nextToken()); // 동생의 위치 K
		
		int result = bfs(n);
		System.out.println(result);
	}
	
	private static int bfs(int n) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		
		int index = n;
		visited[index] = 1; //노드방문여부 true
		
		while(!queue.isEmpty()) {
			n = queue.pop();
			
			if(n == k) { // 동생을 찾았을 때
				return visited[n]-1;
			}
			
			if(n-1 >= 0 && visited[n-1] == 0) { // n-1이 0보다 크고 n-1 방문한 적이 없을 때
				visited[n-1] = visited[n]+1; //현재 시간초+1
				queue.add(n-1);
			}
			
			if(n+1 <= 100000 && visited[n+1] == 0) { // n+1이 100000보다 작고 n+1 방문한 적이 없을 때
				visited[n+1] = visited[n]+1;
				queue.add(n+1);
			}
			
			if(2*n <= 100000 && visited[2*n] == 0) { // 2*n이 100000보다 작고 n+1 방문한 적이 없을 때
				visited[2*n] = visited[n]+1;
				queue.add(2*n);
			}
			
		}
		
		return -1;
	}

}
