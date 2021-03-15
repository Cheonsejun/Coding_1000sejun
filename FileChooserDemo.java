package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class FileChooserDemo extends JFrame implements ActionListener{
	private JButton openBtn, saveBtn;
	JFileChooser fc;
	
	public FileChooserDemo() {
		this.setTitle("���ϼ��ñ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 200);
		fc = new JFileChooser();
		
		JLabel label = new JLabel("���� ���ñ� ������Ʈ �׽�Ʈ�Դϴ�.");
		
		openBtn = new JButton("���� ����");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("���� ����");
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
			if (returnVal == JFileChooser.APPROVE_OPTION) { // APProve �����ϴ�
				File file = fc.getSelectedFile();
				System.out.println("open file : " + file.getAbsolutePath()); // getAbsolutePath�� ���� ���α׷��� ������ ��θ� �����ϰ��ִ�
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
