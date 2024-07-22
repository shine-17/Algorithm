package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2667 {
	
	private static int n;
	private static int[][] apartArr;
	private static List<Integer> complexArr;
	
	private static boolean[][] visited;
	private static int count;
	
	private static int dirX[] = {0, 0, -1, 1};
	private static int dirY[] = {-1, 1, 0, 0};

	public static void main(String[] args) {
		try {
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			
			complexArr = new ArrayList<Integer>();
			apartArr = new int[n][n];
			visited = new boolean[n][n];
			
			String token = null;
			for(int i=0; i<n; i++) {
				token = br.readLine();
				
				for(int j=0; j<token.length(); j++) {
					apartArr[i][j] = token.charAt(j) - 48;
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					
					if(!visited[i][j] && apartArr[i][j] == 1) {
						count = 0;
						
						dfs(i, j);
						
						complexArr.add(count);
					}
				}
			}
			
			Collections.sort(complexArr);
			System.out.println(complexArr.size());
			
			for(Integer i : complexArr) {
				System.out.println(i);
			}
			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(apartArr[i][j]);
//				}
//				System.out.println("");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dfs(int x, int y) {
		// 방문 처리
		visited[x][y] = true;
		
		count++;
		
		// 방문 노드 출력
//		System.out.println(String.format("visited : %s,%s", x, y));
		
		// 방문 노드에 인접한 노드 찾기
		for(int i=0; i<4; i++) {
			try {
				int linkX = x + dirX[i];
				int linkY = y + dirY[i];
				
				if(linkX < 0 || linkY < 0 || linkX >= n || linkY >= n) continue;
				
				int node = apartArr[linkX][linkY];
				
				if(!visited[linkX][linkY] && node == 1) {
					visited[linkX][linkY] = true;
					dfs(linkX, linkY);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		
		
	}

}
