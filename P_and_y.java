package Programmers;

public class P_and_y {
	// level_1 문자열 내 p와 y의 개수
	boolean py (String s) {
		boolean ans = true;
		int p = 0; int y = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == 'p' || c == 'P') {
				p += 1;
			}else if(c == 'y' || c == 'Y') {
				y += 1;
			}
		}
		if(p != y) {
			ans = false;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		P_and_y py = new P_and_y();
		String py1 = "pPoooyY";
		String py2 = "Pyy";
		String py3 = "ss";
		System.out.println(py.py(py1));
		System.out.println(py.py(py2));
		System.out.println(py.py(py3));
	}

}
