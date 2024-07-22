package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BJ_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //포켓몬 개수
		int m = Integer.parseInt(st.nextToken()); //맞춰야 하는 문제 개수
		int num = 1;
		
		HashMap<String, String> pokeMon = new HashMap<String, String>();
		
		for(int i=0; i<n; i++) {
			pokeMon.put(String.valueOf(num++), br.readLine());
		}
		
		Iterator<Entry<String, String>> iter = pokeMon.entrySet().iterator();
		HashMap<String, String> pokeMon2 = new HashMap<String, String>();
		
		while(iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			pokeMon2.put(entry.getValue(), entry.getKey());
		}
		
		pokeMon.putAll(pokeMon2);

		for(int i=0; i<m; i++) {
			String value = br.readLine();
			System.out.println(pokeMon.get(value));
		}
	}

}
