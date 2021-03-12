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
		this.setTitle("�޺��ڽ�����");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		
		c = new JComboBox(animals);
		c.setSelectedIndex(0);
		c.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// SwingConstant�� �������� ���Ǿ����� ����� ������ �������̽��� ����ȴ�.
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
		// getSelectedItem: �޺��ڽ��� ���� ����ڰ� ������ �׸��� �����´�
		changePicture(name);
	}

		
	public void changePicture(String name) {
		ImageIcon icon = new ImageIcon("image/" + name + ".jpg");
		label.setIcon(icon);
		
		label.setText(null);
	}
}
