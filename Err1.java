package ch14;

import java.io.IOException;
import java.io.*;

public class Err1 {

	public static void main(String[] args) {
		writeList();
	}
	private static void writeList() {
		PrintWriter out = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:/abc/out.txt");
			out = new PrintWriter(fw);
			out.println("�ȳ��ϼ���?");
			System.out.println("�۾�����...");
			out.close();
		}catch(IOException e) {
			System.out.println("catch : " + e.getMessage());
		}finally {
			System.out.println("finally code...");
			if(out != null)
				out.close();
			System.out.println("finally end...");
		}
	}

}
