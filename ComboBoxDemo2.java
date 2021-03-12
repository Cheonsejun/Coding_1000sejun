package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxDemo2 extends JFrame implements ActionListener{
	private JComboBox c;
	private String [] animals = {"dog","lion","tiger"};
	private JLabel label;
	
	public ComboBoxDemo2() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("콤보박스연습");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		
		c = new JComboBox(animals);
		c.setSelectedIndex(0);
		c.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// SwingConstant는 스윙에서 사용되어지는 상수를 정의한 인터페이스라 보면된다.
		changePicture(animals[c.getSelectedIndex()]);
		
		this.add(c, BorderLayout.NORTH);
		this.add(label, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComboBoxDemo2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = (String) c.getSelectedItem();
		// getSelectedItem: 콤보박스로 부터 사용자가 선택한 항목을 가져온다
		changePicture(name);
	}

		
	public void changePicture(String name) {
		ImageIcon icon = new ImageIcon("image/" + name + ".jpg");
		label.setIcon(icon);
		
		label.setText(null);
	}
}
