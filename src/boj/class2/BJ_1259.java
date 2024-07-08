package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String palindromeNum = st.nextToken();
			
			if(palindromeNum.equals("0"))
				break;
			
			boolean palindromeTF = false;
			
			for(int i=0; i<palindromeNum.length()/2; i++) {
				if(palindromeNum.charAt(i) != palindromeNum.charAt(palindromeNum.length()-1-i)) {
					palindromeTF = true;
					break;
				}
			}
			
			if(palindromeTF)
				System.out.println("no");
			else
				System.out.println("yes");
		}
		
	}

}
