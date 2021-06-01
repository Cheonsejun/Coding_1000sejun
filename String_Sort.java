package Pro_Level1;

import java.util.*;			


public class String_Sort {
	
	public String[] SS(String[] s, int n) {
		ArrayList<String> list = new ArrayList<>();
		String[] ans = null;
		for(int i = 0; i < s.length; i++) {
			list.add(s[i].charAt(n)+s[i]);
		}
		Collections.sort(list);
		ans = new String[list.size()];
		for(int i = 0; i < s.length; i++) {
			ans[i] = list.get(i).substring(1,list.get(i).length());
		}
		return ans;
	}
	
	public static void main (String[] args){
		String_Sort s = new String_Sort();
		String[] s1 = {"sun", "bed", "car"};
		String[] s2 = {"abce", "abcd", "cdx"};
		
		System.out.println(Arrays.toString(s.SS(s1, 1)));
	}
}
