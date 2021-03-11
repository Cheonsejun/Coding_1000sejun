package Training;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Slot extends JFrame implements ActionListener{
	private JPanel p = new JPanel();
	private JPanel p2 = new JPanel();
	private JLabel[] l = new JLabel[3];
	private JButton btn = new JButton("½ºÇÉ");
	int [] num = new int[3];
	int cnt = 0;
	
	public Slot() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Slot");
		
		
		for(int i = 0; i < 3; i++) {
			l[i] = new JLabel(" " + num[i]);
			l[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));

		}
		
		for(int i = 0; i < 3; i++) {
			p.add(l[i]);
		}
		
		p2.add(btn);
		
		btn.addActionListener(this);
		
		this.add(p);
		this.add(p2, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Slot();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 3; i++) {
			num[i] = (int) (Math.random()*10);
			l[i].setText(" " + num[i]);
		}
	}

}
