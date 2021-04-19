package ch14_2;

import java.util.*;

public class StackTest2 {
	public static void main(String[] args) {
		String str = "apple, banana, carrot, pineapple, grape, mango, strawberry, watermelon, melon, orange, coconut, kiwi, lemon, tomato, cherry, blueberry, peach, cramberry, rasperry";
		
//		String s = str.substring(0, "apple".length());
//		System.out.println(s);
//		공백문자를 기준으로 하나씩 잘라 주세요.
//	         구분자를 입력으로 주고, 그 구분자(delimiter)로 구분되는
//		문자열들을 하나씩, 하나씩 뽑아 쓸 수 있게 해주는
//		java.util 패키지의 클래스가 뭐냐 하면
//		StringTokenizer 
		StringTokenizer st = new StringTokenizer(str, ", "); 
		
//		String s = st.nextToken();
//		System.out.println(s);
		
//		s = st.nextToken();
//		System.out.println(s);
		
		System.out.println("token 수: " + st.countTokens());
//		토큰을 다 찍어 보는 방법1
//		토큰의 수만큼 for문 돌기
		
//		토큰을 다 찍어 보는 방법2
//		아직 나에게 줄 토큰이 남아있는지 물어보고
//		있으면 nextToken() 메소드를 호출해서 하나씩 받아서  사용하기
//		주로 두번째 방법을 많이 사용
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("[" + token + "]");
		}
	}
}
