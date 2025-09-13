package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static ArrayList<Integer> DFS_Arr = new ArrayList<Integer>();
	static ArrayList<Integer> BFS_Arr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //정점의 개수
		int m = Integer.parseInt(st.nextToken()); //간선의 개수
		int v = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
		
		//DFS, BFS로 탐색
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<graph.length; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) { //인접리스트
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		for(int i=0; i<graph.length; i++) {
			Collections.sort(graph[i]);
		}
		
		//DFS
		dfs(v);
		
		for(Integer i : DFS_Arr)
			System.out.print(i + " ");
		System.out.println("");
		
		//BFS
		visited = new boolean[n+1];
		
		bfs(v);
		
		for(Integer i : BFS_Arr)
			System.out.print(i + " ");
		
	}
	
	//DFS
	static void dfs(int n) {
		visited[n] = true; //노드방문여부 true
		DFS_Arr.add(n);
		
		for(int i=0; i<graph[n].size(); i++) {
			int node = graph[n].get(i);
			
			if(!visited[node]) {
				//인접, 방문한 적 없는 노드를 방문
				//node에는 인접노드만 저장되므로 인접조건O
				dfs(node);
			}
			
		}
	}
	
	//BFS
	static void bfs(int n) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[n] = true; //노드방문여부 true
		BFS_Arr.add(n);
		queue.add(n);
		
		while(queue.size() != 0) { //큐(Queue)가 빌 때까지 반복
			//방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
			n = queue.poll();
			
			//방문한 노드와 인접한 모든 노드를 가져옴
			Iterator<Integer> i = graph[n].listIterator();
			while(i.hasNext()) {
				int node = i.next();
				//방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
				if(!visited[node]) {
					visited[node] = true;
					BFS_Arr.add(node);
					queue.add(node);
				}
			}
		}
	}
}
