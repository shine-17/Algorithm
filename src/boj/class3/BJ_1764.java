package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class bj_1764 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Map<String, Boolean> notHearList = new HashMap<String, Boolean>();
			Set<String> notHearSeeList = new TreeSet<String>();
			
			for(int i=0; i<n; i++) {
				notHearList.put(br.readLine(), true);
			}
			for(int i=0; i<m; i++) {
				String key = br.readLine();
				if(notHearList.getOrDefault(key, false)) {
					notHearSeeList.add(key);
				}
			}
			
			System.out.println(notHearSeeList.size());
			for(String s : notHearSeeList)
				System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
