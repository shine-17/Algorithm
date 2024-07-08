package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1780 {
	private static int countN = 0, countZ = 0, countP = 0; // -1 , 0 , 1
	
	private static final int cutCount = 9;

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			Integer[][] paper = new Integer[n][n];
			
			
			for(int i=0; i<n; i++) {
				String[] paperStr = br.readLine().split(" ");
				
				for(int j=0; j<paperStr.length; j++) {
					paper[i][j] = Integer.parseInt(paperStr[j]);
				}
			}
			
			cutPaper(paper);
			
			System.out.println(countN);
			System.out.println(countZ);
			System.out.println(countP);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void cutPaper(Integer[][] paper) {
		if(paper == null || paper.length < 1)
			return;
		
		if(isAllSamePaperNum(paper)) {
			if(paper[0][0] < 0)
				countN++;
			else if(paper[0][0] == 0)
				countZ++;
			else
				countP++;
		} else {
			int newSize = paper.length / 3;
			
			for(int i=0; i<cutCount; i++) {
				int xStartPoint = newSize * (i / 3); // 0 0 0 9 9 9 18 18 18
				int yStartPoint = newSize * (i % 3); // 0 3 6 0 3 6 0 3 6
				Integer[][] newPaper = new Integer[newSize][newSize];
				int xIndex = 0;
				int yIndex = 0;
				
				for(int j=xStartPoint; j<xStartPoint + newSize; j++) {
					for(int k=yStartPoint; k<yStartPoint + newSize; k++) {
						newPaper[xIndex][yIndex++] = paper[j][k];
					}
					xIndex++;
					yIndex = 0;
				}
				
				cutPaper(newPaper);
			}
		}
	}
	
	public static boolean isAllSamePaperNum(Integer[][] paper) {
		int num = paper[0][0];
		
		for(int i=0; i<paper.length; i++) {
			for(int j=0; j<paper[i].length; j++) {
				if(num != paper[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
