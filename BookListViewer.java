package ch19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class BookListViewer extends JFrame implements ActionListener{
	private JTextField idField, titleField, publisherField, yearField, priceField, authorField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;//, deleteBtn, searchBtn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection con = null;
	
	public BookListViewer() throws Exception {
		/*
		 *  DB���� å ���ڵ带 ��������.
		 *  1. JDBC ����̹� ����
		 *  2. DB ����
		 *  3. PreparedStatement ��ü ����
		 *  4. SQL�� ����
		 */
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "72339900");
		String sql = "select * from books order by book_id desc";
		pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// select ���� ������ ���� executeQuery() �޼��带 ����ϰ�
		// �� ��, insert, delete, update ���� ������ ����
		// executeUpdate() �޼��带 ����Ѵ�.
		
		rs = pstmt.executeQuery();
		
		// �� JFrame ��ü(this)�� Layout�� GirdLayout���� ����(0, 2)
		this.setLayout(new GridLayout(0, 2));
		
		// ������Ʈ���� ����
		// ������ ������Ʈ���� JFrame ��ü(this)�� �߰��Ѵ�.
		this.add(new JLabel("10", JLabel.CENTER));
		idField = new JTextField(10);
	  	this.add(idField);
		
	  	this.add(new JLabel("Title", JLabel.CENTER));
	  	titleField = new JTextField(10);
	  	this.add(titleField);
		
	  	this.add(new JLabel("Publisher", JLabel.CENTER));
	  	publisherField = new JTextField(10);
	  	this.add(publisherField);
	  	
	  	this.add(new JLabel("Year", JLabel.CENTER));
	  	yearField = new JTextField(10);
	  	this.add(yearField);
	  	
	  	this.add(new JLabel("Price", JLabel.CENTER));
	  	priceField = new JTextField(10);
	  	this.add(priceField);
		
		// ��ư ������Ʈ���� �׼Ǹ����ʸ� �� ��ü(this)�� �����ȴ�.
	  	previousBtn = new JButton("Previous");
	  	previousBtn.addActionListener(this);
	  	this.add(previousBtn);
	  	
	  	nextBtn = new JButton("Next");
	  	nextBtn.addActionListener(this);
	  	this.add(nextBtn);
	  	
	  	insertBtn = new JButton("Insert");
	  	insertBtn.addActionListener(this);
	  	this.add(insertBtn);
	  	
	  	finishBtn = new JButton("Finish");
	  	finishBtn.addActionListener(this);
	  	this.add(finishBtn);
	  	
//	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	  	this.setResizable(false);
	  	this.setSize(350, 200);
	  	this.setLocationRelativeTo(null);
	  	
	  	this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	try {
		if(e.getSource() == previousBtn) {
			System.out.println("PreviousBtn clicked...");
			// ��������� Ŀ���� �������� �̵��ϰ�
			rs.previous();
			// �� Ŀ���� ����Ű�� ��� ���ڵ��� Į������ �̾� �ͼ�
			// ������ JTextField ������ ����.
			setCurrentBookInfo2TextField();
		}else if(e.getSource() == nextBtn) {
			System.out.println("nextBtn clicked...");
			rs.next();
			setCurrentBookInfo2TextField();
		}else if(e.getSource() == insertBtn) {
			System.out.println("insertBtn clicked...");
		}else if(e.getSource() == finishBtn) {
			System.out.println("finishBtn clicked...");
			System.out.println("���α׷��� �����մϴ�...");
			con.close();
			System.exit(0); // ���μ����� �����Ų��.
		}
	}catch(Exception err) {
		System.out.println(err);
	}
	}
	
	private void setCurrentBookInfo2TextField() throws Exception{
		// book_id, title, publisher, year, price
		int bookId = rs.getInt("book_id");
		String title = rs.getString("title");
		String publisher = rs.getString("publisher");
		Date year = rs.getDate("year");
		int price = rs.getInt("price");
		
		idField.setText(String.valueOf(bookId));
		titleField.setText(title);
		publisherField.setText(publisher);
		yearField.setText(year.toString());
		priceField.setText(String.valueOf(price));
	}

	public static void main(String[] args) throws Exception{
		// BookListViewer Ŭ������ �ν��Ͻ� ����
		new BookListViewer();
	}
	
}
