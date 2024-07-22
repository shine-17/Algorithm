package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	
	private static boolean[] visited;
	
	private static int[] dist;
	
	private static List<List<Integer>> maze = new ArrayList<List<Integer>>();
	
	private static int n, m;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
					
			int[][] mazeArr = new int[n][m];
			visited = new boolean[n * m];
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				
				for(int j=0; j<str.length(); j++) {
					mazeArr[i][j] = str.charAt(j) - 48;
				}
			}

			// 2차원 배열 -> 1차원 배열
			for(int i=0; i<mazeArr.length; i++) {
				for(int j=0; j<mazeArr[i].length; j++) {
					List<Integer> movable = new ArrayList<Integer>();
					
					addMaze(mazeArr, movable, i, j);
					
					maze.add(movable);
				}
			}
			
//			for(int i=0; i<maze.size(); i++)
//				System.out.print(maze.get(i));
			
			dist = new int[n * m];
			bfs(0);
			
			System.out.println(dist[n*m-1]);
			
//			for(int i=0; i<dist.length; i++) {
//				System.out.print(dist[i] + " ");
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addMaze(int[][] mazeArr, List<Integer> movable, int i, int j) {
		int len = m * i + j;
		int index = 0;
		
		// 왼쪽 1칸
		if(len > 0 && len % m != 0) {
			index = len - 1;
			
			if(mazeArr[index / m][index % m] == 1) movable.add(index);
		}
		// 위로 1칸
		if(len >= m) {
			index = len - m;
			
			if(mazeArr[index / m][index % m] == 1) movable.add(index);
		}
		// 오른쪽 1칸
		if(len < (n * m - 1) && len % m != (m-1)) {
			index = len + 1;
			
			if(mazeArr[index / m][index % m] == 1) movable.add(index);
		}
		// 아래 1칸
		if(len < (n * m - m)) {
			index = len + m;
			
			if(mazeArr[index / m][index % m] == 1) movable.add(index);
		}
		
		Collections.sort(movable);
//		System.out.println(len + " : " + movable);
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		int count = 1;
		dist[v] = count;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
//			System.out.println("node : " + node + ", count : " + dist[node]);
			
			if(node == (n * m - 1))
				break;
			
			for(int i : maze.get(node)) {
				if(visited[i] == false) {
					visited[i] = true;
					queue.add(i);
					dist[i] = dist[node]+1;
				}
			}
		}
	}
	
}
