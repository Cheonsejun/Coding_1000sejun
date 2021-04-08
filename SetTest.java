package ch14;

import java.util.*;
import java.io.*;

public class SetTest {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		File file = new File("wordbook.txt");
		Set<String> set = new HashSet<>();
		if (file.exists() == true) {
			System.out.println(file.getAbsolutePath() + ": ������");
		}else {
			// getParent "������ ������ ���´�"
			System.out.println(file.getAbsolutePath() + ": �������� ����");
		}
		// ���ϳ����� ����.
		// ���Ͽ� �ϰ� ������ stream ��ü�� �̿��ؾ� �Ѵ�.
		/*
	           ���� ���� Input Stream
		  �� ���� Out Stream
		 Stream�� �⺻������ Byte Stream.
		  �׷��� ���ڴ����� �а� �� ���� ���� ��Ʈ���� �̿��ϴ� ���� ����.
		  ���ڴ����� �Է� ��Ʈ���� Reader ��ü��  ǥ���ȴ�.
		  ���ڴ����� ��� ��Ʈ���� Writer ��ü�� ǥ���ȴ�.
		*/
//		FileReader fileReader = new FileReader("wordbook.txt");
		// FileRaader�� �ѹ��ھ� ���� �� ���
		int cnt = 0;
		// ���� ������ �б� ���ؼ� BufferdReader�� �̿�
		BufferedReader bReader = null;
		try {
			FileReader fileReader = new FileReader(file);
			bReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bReader.readLine()) != null) {
//				String line = bReader.readLine();
//				if(line == null) break;
				System.out.println(line);
				set.add(line); // �ߺ����� ���� ���ڿ��� �߰��ȴ�.
				cnt++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
			bReader.close();
			}catch (Exception e) {
				
			}
		}
		System.out.println("�ܾ� ��(�ߺ�����): " + cnt);
		System.out.println("�ܾ� ��(�ߺ�������): " + set.size());
		
//		}catch(FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		}catch(IOException e) {
//			
//		}
	}
}
