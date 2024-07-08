package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1181_1 {
	static String[] wordArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		wordArr = new String[n];
		
		for(int i=0; i<wordArr.length; i++) {
			wordArr[i] = br.readLine();
		}
		
		for(int i=0; i<wordArr.length-1; i++) {
			for(int j=0; j<wordArr.length-1; j++) {
				if(wordArr[j].length() > wordArr[j+1].length()) {
					changeValue(j, j+1);
				} else if(wordArr[j].length() == wordArr[j+1].length()) { //길이가 같을 때
					for(int k=0; k<wordArr[j].length(); k++) {
						if(wordArr[j].equals(wordArr[j+1])) { //단어가 같을 때
							wordArr[j+1] = "word_overlap";
							break;
						}
						else if((wordArr[j].charAt(k) - 65) > (wordArr[j+1].charAt(k) - 65)) {
							changeValue(j, j+1);
							break;
						} else if((wordArr[j].charAt(k) - 65) == (wordArr[j+1].charAt(k) - 65)){
							continue;
						} else {
							break;
						}
					}
				}
			}
		}
		
		for(String word : wordArr) {
			if(!word.equals("word_overlap"))
				System.out.println(word);
		}
	}
	
	public static void changeValue(int i, int j) {
		String temp = null;
		
		temp = wordArr[i];
		wordArr[i] = wordArr[j];
		wordArr[j] = temp;
	}

}
