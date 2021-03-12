package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Function2 extends JPanel implements ActionListener{
	private JTextField a, b, c; 
	private double A, B, C;
	
	public Function2() {
		a = new JTextField("1.0",10);
		b = new JTextField("-5.0",10);
		c = new JTextField("6.0",10);
		
		this.add(a);
		this.add(b);
		this.add(c);
		
		JButton btn = new JButton("Draw");
		this.add(btn);
		btn.addActionListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D d2 = (Graphics2D) g;
		
		d2.drawLine(0, 200, 400, 200);
		d2.drawLine(200, 0, 200, 400);
		
		d2.setPaint(Color.red);
		for(int i = -20; i < 20; i++) {
			int x = i;
			int y = (int) (A * x * x - B * x + C);
			d2.fillOval(200 - x -2, 200 - (y -2), 4, 4);
		}
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("2Â÷ÇÔ¼ö");
		
		f.add(new Function2());
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		A = Double.parseDouble(a.getText());
		B = Double.parseDouble(b.getText());
		C = Double.parseDouble(c.getText());
		repaint();
	}

}
