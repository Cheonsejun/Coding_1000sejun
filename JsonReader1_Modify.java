package ch18.network;


import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JsonReader1_Modify {

	public static void main(String[] args) throws Exception{
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();
		
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
		
		BufferedReader bufReader = new BufferedReader(reader);
		
		String line = null;
		String jsonString = "";
		while((line = bufReader.readLine()) != null) {
//			System.out.println(line);
			jsonString += line;
		}
		
		Gson gson = new Gson();
//		String json = "{'userid':'1', 'id':'1', 'title':'test', 'body':'testbody'}";
		Post[] posts = gson.fromJson(jsonString, Post[].class);
		/*
		 *  Post post = new Post();
		 *  post.setUserid(1);
		 *  post.id(1);
		 *  post.title("title");
		 *  post.body("testbody");
		 *  return post;
		 */
		
		for(Post post : posts) {
			System.out.println("UserId: " + post.getUserId());
			System.out.println("Id: "+ post.getId());
			System.out.println("Title: " + post.getTitle());
			System.out.println("Body: " + post.getBody());
			System.out.println("#################");
		}
		
		insertIntoDB(posts);
	}
	
	private static void insertIntoDB(Post[] posts) throws Exception{
		/*
		 * 1. Class.forname(...); // JDBC 드라이버 메모리에 적재
		 * 2. Connection con =
		 * 		DriverManger.getConnection(...); DB 서버에 연결
		 * 3. String sql = "insert into posts(userId, id, title, body);
		 * 								values(?, ?, ?, ?);
		 * PreparedStetament pstmt = con.preparedStetament(sql);
		 * 
		 * 4. ? 자리에 들어갈 값을 설정한다.
		 * 	psmt.setInt(1, post.getUserId());
		 *  psmt.setInt(2, post.getId());
		 *  psmt.setString(3, post.getTitle());
		 *  psmt.setString(4, post.getBody());
		 *  
		 * 5. 서버에 실행 요청
		 * 	pstmt.executeUpdate();
		 * 6. con.close();
		 */
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/oop";
		String id = "root";
		String pw = "72339900";
		Connection con = DriverManager.getConnection(url,id,pw);
		String sql = "insert into posts(userId, id, title, body) values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for(Post post : posts) {
			pstmt.setInt(1, post.getUserId());
			pstmt.setInt(2, post.getId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getBody());
			
			pstmt.executeUpdate();
		}
		con.close();
	}
}
