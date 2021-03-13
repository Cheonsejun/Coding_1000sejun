package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo2 extends JFrame implements ChangeListener{
	private static int INIT_VALUE = 15;
	private JButton btn;
	private JSlider s;
	private JPanel p = new JPanel();;
	
	public SliderDemo2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�����̴� ����");
		this.setSize(400,400);
		
		JLabel la = new JLabel("�����̴��� ������ ������");
		la.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(la);
		
		s = new JSlider(0, 30, 15);
		s.setMajorTickSpacing(10); // �����̴� ū ���� ����
		s.setMinorTickSpacing(1); // ���� ���� ����
		s.setPaintTicks(true); // ������ ǥ���Ѵ�
		s.setPaintLabels(true); // ���� ���̺�� ǥ���Ѵ�
		s.addChangeListener(this);
		p.add(s);
		this.add(p);
		
		ImageIcon icon = new ImageIcon("image/dog.jpg");
		btn = new JButton(icon);
		btn.setSize(INIT_VALUE * 10, INIT_VALUE * 10);
		
		this.add(btn, BorderLayout.CENTER);
		this.add(s, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SliderDemo2();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if(!source.getValueIsAdjusting()) {
			int value = (int) source.getValue();
			btn.setSize(value * 10, value * 10);
		}
	}

	

}
