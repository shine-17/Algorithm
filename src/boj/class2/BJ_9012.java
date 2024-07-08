package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> bracket = new ArrayList<String>();
			String str = st.nextToken();
			boolean is_vps = true;
			
			for(int j=0; j<str.length(); j++) {
				String token = String.valueOf(str.charAt(j));
				
				if(token.equals("(")) {
					bracket.add(token);
				} else {
					if(bracket.size() > 0 && bracket.get(bracket.size()-1).equals("(")) {
						bracket.remove(bracket.size()-1);
					} else {
						is_vps = false;
					}
				}
			}
			
			if(bracket.size() > 0 || is_vps == false)
				System.out.println("NO");
			else
				System.out.println("YES");
		}

	}

}
