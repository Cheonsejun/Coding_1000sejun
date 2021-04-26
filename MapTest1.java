package ch14_2;
import java.util.*;
import java.util.Map.*;
public class MapTest1 {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	public static void test2() {
		/*
		 *  ģ���� ��ȭ��ȣ�� �����ϴ� map ��ü �����Ҳ���.
		 *  <�̸�, ��ȭ��ȣ> // "ȫ�浿", "010-1234-5678"
		 */
		
		String[] names = {"ȫ�浿", "������", "������", "�̸���"};
		String[] phones = {"010-1234-5678", "010-2234-5578", "010-1235-7678", "010-2244-2255"};
		Map<String, String> phoneBook =  new HashMap<>();
		
		for(int i = 0; i < names.length; i++) {
			phoneBook.put(names[i], phones[i]);
		}
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("ģ�� �̸�:");
			String name = input.next();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name + "�� ��ȭ�¹�ȣ�� " + phone + "�Դϴ�.");
		}
	}
	
	public static void test1() {
		/*
		 *  Map ��ü, HashMap ��ä�� ��������
		 *  ���� <key, value>�� ������ �����ϰ�
		 *  key ���� ���� ���� �����Ѵ�.
		 *  Map�̶�� ���� generic �������̽����̰�
		 *  �̰� ������ HashMap, TreeMap, LinkedHashMao Ŭ��������
		 *  ���׸� Ŭ������� ���Դϴ�.
		 *  �� �ǹ̴�
		 *  �� ��ü���� ������ �� Ÿ���� ��������� �Ѵ�.
		 */
		
//		ArrayList<Integer> list = new ArrayList<>();
//		ArrayList<String> list2 = new ArrayList<>();
//		ArrayList<Student> list3 = new ArrayList<>();
//		
		
//		Map�� <�й�, �л���ü> �̷��� ������ ����
		HashMap<String, Student2> map = new HashMap<>();
		
//		map = new TreeMap<>();
		
		map.put("2000101", new Student2(2000101, "ȫ�浿"));
		map.put("2000102", new Student2(2000102, "������"));
		map.put("2000103", new Student2(2000103, "�̸���"));
		map.put("2000104", new Student2(2000104, "������"));
		map.put("2000105", new Student2(2000105, "����"));
		
//		Student2 value = map.get("2000103");
//		System.out.println(value.getName());
//		map.put("2000103", new Student2(2000103,"�̻��"));
//		value = map.get("2000103");
//		System.out.println(value.getName());
		
		/*
		 *  map�̶�� �ڷᱸ���� �� �ִ� ��� ���ҵ��� �� ���� �� �ִ� �����
		 *  1. map���� �ϰ� ���� ���Ҹ� ��� Ű ������ ��û�ϰ�
		 *  	�� ������ �� ���Ҹ� ������ map���� ���� ��û�ϴ� ���
		 *  2. map���� <key, value> ������ ����� ��Ʈ�� ������ ��û�ؼ�
		 *  	�� ������ ���Ҹ� �ϳ��� �д� ���.
		 */
		
		Set<String> keyset = map.keySet();
		// set�� ���Ҹ� �ϳ��� �����Ѵ� �����?
		
//		Iterator<String> iter = keyset.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			Student2 val = map.get(key);
//			System.out.println("key:" + key + ", value: " + val.getName());
//		}
		
		// map���� ��Ʈ���� ���� <key, value>�� ������ ������ ��ü.
		// ��ü�� ���� �� ��ü�� �����ϴ� Ŭ������ �ִٴ� �ǹ�.
		Set<Entry<String, Student2>> entryset = map.entrySet();
		Iterator<Entry<String, Student2>> eIter = entryset.iterator();
		while(eIter.hasNext()) {
			Entry<String, Student2> entryObj = eIter.next();
			String key = entryObj.getKey();
			Student2 val = entryObj.getValue();
			System.out.println("key: " + key + ", value: " + val);
		}
	}
}

class Student2{
	private int hakbun;
	private String name;
	
	@Override
	public String toString() {
		return "[�й�: " + hakbun + ", �̸�: " + name + "]"; 
	}
	public Student2(int hakbun, String name) {
		super();
		this.hakbun = hakbun;
		this.name = name;
	}
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

