package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1012 {
	static int[][] field;
	static boolean[][] visit;
	
	static int M; //배추밭 가로길이
	static int N; //배추밭 세로길이
	static int K; //심은 배추의 개수
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1}; //상하좌우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //배추밭 가로길이
			N = Integer.parseInt(st.nextToken()); //배추밭 세로길이
			K = Integer.parseInt(st.nextToken()); //심은 배추의 개수
			field = new int[N][M]; //배추밭
			visit = new boolean[N][M]; //배추밭 방문여부 - DFS에서 방문여부 필수
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				field[x][y] = 1;
			}
		
			int count = 0; //배추흰지렁이 수
			
			for(int j=0; j<field.length; j++) {
				for(int k=0; k<field[j].length; k++) {
					if(field[j][k] == 1 && !visit[j][k]) { //배추가 있고 방문하지 않은 배추(노드)
						dfs(j, k);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	static void dfs(int j, int k) {
		//방문체크
		visit[j][k] = true;
		
		//상하좌우 탐색 - 인접한 배추
		for(int i=0; i<4; i++) {
			int a = j + dr[i];
			int b = k + dc[i];
			
			if(a >= 0 && b >= 0 && a < N && b < M) { //배추밭 범위 안일 때
				if(field[a][b] == 1 && !visit[a][b]) ////DEPTH를 계속 탐색한다
					dfs(a, b);
			}
		}
	}
}
