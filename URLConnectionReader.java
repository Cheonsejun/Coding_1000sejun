package ch18.network;

import java.net.*;
import java.io.*;

public class URLConnectionReader {

	public static void main(String[] args) throws Exception{
		// 1. URL ��ü
		URL site = new URL("https://www.naver.com/");
		
		// 2. URL ��ü�κ��� �� ����Ʈ�� ������ �õ��Ѵ�. openConnection();
		URLConnection con = site.openConnection();
		
		// 3. InputStream ��ü�� ���� ��Ʈ��ũ �ʸ��� ���μ����� �����ִ� �����͸� �д´�.
		InputStream stream = con.getInputStream();
		
		InputStreamReader isreader = new InputStreamReader(stream);
		
		BufferedReader reader = new BufferedReader(isreader);
		String line = reader.readLine();
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

}
