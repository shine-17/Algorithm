package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj_1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		BigInteger factorial = new BigInteger("1");
		
		for(int i=n; i>=1; i--) {
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}
		
		for(int i=String.valueOf(factorial).length()-1; i>=0; i--) {
			if(String.valueOf(factorial).charAt(i) != '0')
				break;
			else
				count++;
		}
		
		System.out.println(count);
	}
}
