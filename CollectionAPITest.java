package ch15;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
public class CollectionAPITest {
	private String name;
	
	public CollectionAPITest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sample = {"i", "walk", "the", "line"};
		List<String> list = Arrays.asList(sample);
		
//		Collections의 sort메서드는 List타입을
//		인자로 가진다
		System.out.println("정렬전...");
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println("정렬후...");
		System.out.println(list);
		
//		Collections.reverse(list);
//		System.out.println(list);
		
		Collections.sort(list, new MyString());
		System.out.println("내림차순 정렬후...");
		System.out.println(list);
		
	}

	public static int add(int n1,int n2){
		return n1 + n2;
	}
	
}

class MyString implements Comparator<String>{

	@Override
	public int compare(String n1, String n2) {
		// TODO Auto-generated method stub
		
//		return n2.compareTo(n1);
		return n1.compareTo(n2) * (-1);
	}
	
}
