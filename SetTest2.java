package ch14;
import java.util.*;
public class SetTest2 {

	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 5, 4, 3, 2);
//		Set<Integer> set1 = new LinkedHashSet<>();
		MyComparator mc =  new MyComparator(); 
//		Set<Integer> set1 = new TreeSet<>();
		Set<Integer> set1 = new TreeSet<>(mc);
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		// 입력된 순서대로 나오는지 출력
		// 또는 값의 순서대로 나오는지 출력
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static void test1() {
		/*
		   	set1 = {2, 4, 6, 8, 10}
		   	set2 = {1, 3, 5, 7, 9}
		   	합집합  : set1.addAll(list) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		   	교집합  : set1.retainAll(set2) = {3 , 5, 9} 
		   	차집합  = set1 - set2 : set1.removeAll(set2) => {2, 4, 6, 8, 10}
		   		   set2 - set1 : set2.removeAll(set1) => {1, 7}
		 */
		// Generic 클래스 객체를 생성할 때 타임 파라미터는
		// 프리미티브 타입을 줄 수 없다. 객체타입만 줄 수 있다/
		// HashSet, LinekedHashSet, TreeSet
		// LinekedHashSet은 입력순서대로 인출됨
		// TreeSet은 값에 따라 정렬된 순서로 인출됨
		Set<Integer> set1 = new HashSet<>();
		// {2, 3, 4, 5, 6, 8, 9, 10}
        // {2,3,4,5,6,8,9,10};
		
        /*
        set1.add(2);
        set2.add(3);
        */
		
		// 배열을 Collection 객체로 만들어주는 메소드가 있다
//		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10);
		List<Integer> list = Arrays.asList(10, 9, 5234, 6, 5 ,4 ,3 ,2 ,1);
		set1.addAll(list);
//		set1.add(2); set1.add(3); set1.add(4); set1.add(5);
//		set1.add(6); set1.add(8); set1.add(9); set1.add(10);
		
		// {1, 3, 5, 7, 9}
        Set<Integer> set2 = new HashSet<>(); 
        List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
        set2.addAll(list2);
        
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        
        Set<Integer> unionSet = new HashSet<>(set1);;
        set1.addAll(set2);
//        {1,2,3,4,5,6,7,8,9,10}
        System.out.println("set1 합집합 set2:" + unionSet);
        
        // 교집합
        Set<Integer> IntersectionSet = new HashSet<>(set2);
        set1.retainAll(set1);
        // {3, 5, 9}
        System.out.println("set1 차집합 set2:" + IntersectionSet);
        
        // 차집합
        Set<Integer> diffSet = new HashSet<>(set1);
        diffSet.remove(set2);
        System.out.println("set1 차집합 set2: " + diffSet);
        
//        for(int i = 0; i < diffSet.size(); i++) {
//        	diffSet.get(i);
//        }
        
        System.out.println("####################");
//        for(Integer val : diffSet) {
//        	// val값을 적절히 처리해줘..
//        	System.out.println(val);
//        }
        Iterator <Integer> iter = diffSet.iterator();
        while(iter.hasNext()) {
        	Integer val = iter.next();
        	// val 적절히 처리
        	System.out.println(val);
        }
        System.out.println("####################");
        
        Set<Integer> diffSet2 = new HashSet<>(set2);
        diffSet.remove(set1);
        System.out.println("set2 차집합 set1: " + diffSet2);
	}
	
}

class MyComparator implements Comparator<Integer>{
	
	@Override
	public int compare(Integer n1, Integer n2) {
		// TODO Auto-generated method stub
		// 앞에 인자로 전달된 놈이 크면 양수
		// 같으면 0
		// 뒤에 인자로 전달된 놈이 크면 음수
		return n2 - n1; // n1 -n2 오름차순정렬
	}
	
}