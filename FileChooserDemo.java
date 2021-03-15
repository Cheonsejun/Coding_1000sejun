package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class FileChooserDemo extends JFrame implements ActionListener{
	private JButton openBtn, saveBtn;
	JFileChooser fc;
	
	public FileChooserDemo() {
		this.setTitle("파일선택기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 200);
		fc = new JFileChooser();
		
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		
		openBtn = new JButton("파일 오픈");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("파일 저장");
		saveBtn.addActionListener(this);
		
		JPanel p = new JPanel();
		
		p.add(label);
		p.add(openBtn);
		p.add(saveBtn);
		
		this.add(p);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FileChooserDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(openBtn == e.getSource()) {
			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) { // APProve 승인하다
				File file = fc.getSelectedFile();
				System.out.println("open file : " + file.getAbsolutePath()); // getAbsolutePath는 현재 프로그램을 실행한 경로를 포함하고있다
			}else {
				System.out.println("No file selected");
			}
		}else if (saveBtn == e.getSource()) {
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				System.out.println("open file : " + file.getAbsolutePath());
			}else {
				System.out.println("No file selected");
			}
		}
	}

}
