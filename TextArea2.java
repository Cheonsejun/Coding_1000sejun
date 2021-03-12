package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextArea2 extends JFrame implements ActionListener{
	private JTextField txt;
	private JTextArea area;
	
	public TextArea2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txt = new JTextField(30);
		txt.addActionListener(this);
		
		area = new JTextArea(10,30);
		area.setEditable(false);
		
		JScrollPane scr = new JScrollPane(area);
		
		this.add(txt, BorderLayout.NORTH);
		this.add(scr, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextArea2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = txt.getText();
		
		area.append(text + "\n");
		area.selectAll();
		area.setCaretPosition(area.getDocument().getLength());
		
	}

}
