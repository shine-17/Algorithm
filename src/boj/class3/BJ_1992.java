package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1992 {
	
	private static int[][] quadTree;
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			
			quadTree = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				
				for(int j=0; j<str.length(); j++) {
					quadTree[i][j] = str.charAt(j) - 48;
				}
				
			}
			
			String compressResult = compressQuadTree(0, 0, n);
			
			System.out.println(compressResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String compressQuadTree(int row, int col, int size) {
		if(isAllSame(row, col, size)) {
			
			return String.valueOf(quadTree[row][col]);
			
		} else {
			String compressResult = "(";
			
			size = size/2;
			
			// 2사분면
			compressResult += compressQuadTree(row, col, size);
			// 1사분면
			compressResult += compressQuadTree(row, col + size, size);
			// 3사분면
			compressResult += compressQuadTree(row + size, col, size);
			// 4사분면
			compressResult += compressQuadTree(row + size, col + size, size);
				
			return compressResult + ")";
		}
	}
	
	
	public static boolean isAllSame(int row, int col, int size) {
		int elem = quadTree[row][col];
		
		for(int i=row; i<row + size; i++) {
			for(int j=col; j<col + size; j++) {
				if(elem != quadTree[i][j]) return false;
			}
		}
		
		return true;
	}
}
