package ch13;

import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener{
	private Random random = new Random();
	private JButton[] btn = new JButton[9];
	private JButton b;
	 boolean player1Turn = false;
	private JLabel la1 = new JLabel();
//	Main main = new Main();
	public TicTacToe() {
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TicTacToe");
		
		// 게임제목 출력
		JPanel p = new JPanel();
		p.setBackground(Color.black);
		la1.setText("TicTacToe");
		la1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
		la1.setForeground(Color.green);
		la1.setHorizontalAlignment(JLabel.CENTER);
		p.add(la1);
		
		// 게임화면
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(3,3));
		for(int i = 0; i < 9; i++) {
				btn[i] = new JButton();
				btn[i].setText("");
				btn[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,120));
				btn[i].addActionListener(this);
				board.add(btn[i]);
		}
	
		// Restart 버튼
		b = new JButton("Restart");
		b.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		this.add(b, BorderLayout.SOUTH);
		
		this.add(p, BorderLayout.NORTH);
		this.add(board, BorderLayout.CENTER);
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b) {
					for(int i = 0; i < 9; i++) {
						btn[i].setText("");
						btn[i].setEnabled(true);
						btn[i].setBackground(Color.white);
					}
					la1.setText("TicTacToe");
				}
			}
			
		});
		
		this.setVisible(true);
		
		firstTrun();
	}
	
	private void firstTrun() {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		if(random.nextInt(2) == 0) {
			player1Turn = true;
			la1.setText("X Turn");
		}else {
			player1Turn = false;
			la1.setText("O Turn");
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < btn.length; i++) {
			if(e.getSource() == btn[i]) {
				if(btn[i].getText().equals("")) {
					if(player1Turn) {
						btn[i].setForeground(Color.blue);
						btn[i].setText("X");
						player1Turn = false;
						la1.setText("O Trun");
					}else {
						btn[i].setForeground(Color.red);
						btn[i].setText("O");
						player1Turn = true;
						la1.setText("X Trun");
					}
				}
			}
		}
	}

}
