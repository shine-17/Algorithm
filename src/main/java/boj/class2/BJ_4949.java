package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("."))
				break;
			
			ArrayList<String> arr = new ArrayList<String>();
			boolean balance = true;
			
			for(int i=0; i<str.length(); i++) {
				String bracket = String.valueOf(str.charAt(i));
				
				if(bracket.equals("(") || bracket.equals("[")) {
					arr.add(bracket);
				} else if(bracket.equals(")")) {
					if(arr.size() > 0 && arr.get(arr.size()-1).equals("(")) {
						arr.remove(arr.size()-1);
					} else {
						balance = false;
						break;
					}
				} else if(bracket.equals("]")) {
					if(arr.size() > 0 && arr.get(arr.size()-1).equals("[")) {
						arr.remove(arr.size()-1);
					} else {
						balance = false;
						break;
					}
				} else if(i == str.length()-1) {
					String other = String.valueOf(str.charAt(i-1));
					
					if(other.equals("(") || other.equals("[")) {
						balance = false;
						break;
					}
				}
			}
			
			if(balance == false || arr.size() > 0) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}

	}
}
