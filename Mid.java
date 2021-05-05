package Programmers;

public class Mid {
	public String mid(String s) {
		String answer = "";
		if(s.length() % 2 == 1) {
			return s.substring(s.length()/2, s.length()/2 +1);
		}else {
			return s.substring(s.length()/2-1 , s.length()/2 +1 );
		}
	}
	
	public static void main(String[] args) {
		Mid m = new Mid();
		System.out.println(m.mid("abcde"));
		System.out.println(m.mid("qwer"));
	}
}


