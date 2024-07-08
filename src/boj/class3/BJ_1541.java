package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		int ans = 0;
		
		if(value.indexOf("-") > -1) { // - 연산자 있을 때
			String[] sub = value.split("-");
			
			if(sub[0].indexOf("+") > -1) {
				String[] add = sub[0].split("\\+");
				
				for(int i=0; i<add.length; i++)
					ans += Integer.parseInt(add[i]);
			} else {
				ans = Integer.parseInt(sub[0]);
			}
			
			for(int i=1; i<sub.length; i++) {
				if(sub[i].indexOf("+") > -1) {
					String[] exp = sub[i].split("\\+");
					int sum = 0;
					
					for(int j=0; j<exp.length; j++) {
						sum += Integer.parseInt(exp[j]);
					}
					ans -= sum;
				} else {
					ans -= Integer.parseInt(sub[i]);
				}
			}
		} else { // - 연산자 없을 때
			String[] add = value.split("\\+");
			
			for(int i=0; i<add.length; i++) {
				ans += Integer.parseInt(add[i]);
			}
		}
		
		System.out.println(ans);
		
		/*
		  
		  	30  70  20+40  10+100+30  35
		  	
		  	30 70 60 140 35
		  	
		 */
	}

}
