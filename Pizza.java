package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pizza extends JFrame implements ActionListener{
	int sum, temp1, temp2, temp3;
	private JButton orderBtn, cancelBtn;
	private JTextField price;
	
	WelcomePanel w = new WelcomePanel();
	typePanel tp =  new typePanel();
	toppingPanel tt = new toppingPanel();
	sizePanel sp = new sizePanel();
//	
	public Pizza() {
		this.setTitle("���� ����");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		
		JPanel p  = new JPanel();
		orderBtn = new JButton("�ֹ�");
		cancelBtn = new JButton("���");
		
		p.add(orderBtn);
		orderBtn.addActionListener(this);
		p.add(cancelBtn);
		cancelBtn.addActionListener(this);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(6);
		
		p.add(price);
		this.add(p, BorderLayout.SOUTH);
		
		
		
		this.add(new WelcomePanel(), BorderLayout.NORTH);
		this.add(new typePanel(), BorderLayout.WEST);
		this.add(new toppingPanel(), BorderLayout.CENTER);
		this.add(new sizePanel(), BorderLayout.EAST);
		
		this.setVisible(true);
	}


	public static void main(String[] args) {
		new Pizza();
	}

	// �ڹ� ���� �λ縻 �г�
	class WelcomePanel extends JPanel{
		private JLabel message;
		public  WelcomePanel() {
			message = new JLabel("�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�.");
		    this.add(message);	
		}
	}
	
	// ���� �г�
	class typePanel extends JPanel implements ChangeListener{
		private JRadioButton combo, potato, bulgogi;
		public typePanel() {
			this.setLayout(new GridLayout(3,1));
			combo = new JRadioButton("�޺�");
			potato = new JRadioButton("��������");
			bulgogi = new JRadioButton("�Ұ��");
			
			ButtonGroup gr = new ButtonGroup();
			gr.add(combo);
			gr.add(potato);
			gr.add(bulgogi);
			this.setBorder(BorderFactory.createTitledBorder("����"));
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if (combo == e.getSource()) {
				temp1 = 0;
			}else if(potato == e.getSource()) {
				temp1 = 1;
			}else {
				temp1 = 2;
			}
		}
	}
	
	// �߰� ���� �г� 
	class toppingPanel extends JPanel implements ChangeListener{
		private JRadioButton pepper, cheese, pepperoni, bacon;
		public toppingPanel() {
			this.setLayout(new GridLayout(4,1));
			pepper = new JRadioButton("�Ǹ�");
			cheese = new JRadioButton("ġ��");
			pepperoni = new JRadioButton("����δ�");
			bacon = new JRadioButton("������");
			
			ButtonGroup gr = new ButtonGroup();
			gr.add(pepper);
			gr.add(cheese);
			gr.add(pepperoni);
			gr.add(bacon);
			
			this.setBorder(BorderFactory.createTitledBorder("�߰� ����"));
			
			this.add(pepper);
			this.add(cheese);
			this.add(pepperoni);
			this.add(bacon);
		}
		@Override
		public void stateChanged(ChangeEvent e) {
			if (pepper == e.getSource()) {
				temp2 = 0;
			}else if(cheese == e.getSource()) {
				temp2 = 1;
			}else if(pepperoni == e.getSource()){
				temp2 = 2;
			}else {
				temp2 = 3;
			}
		}
	}
	
	// ������ �г�
	class sizePanel extends JPanel implements ChangeListener{
		private JRadioButton small, medium, large;
	    public sizePanel() {
	    	this.setLayout(new GridLayout(3,1));
			small = new JRadioButton("Small");
			medium = new JRadioButton("Medium");
			large = new JRadioButton("Large");
			
			ButtonGroup gr = new ButtonGroup();
			gr.add(small);
			gr.add(medium);
			gr.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("ũ��"));
			
			this.add(small);
			this.add(medium);
			this.add(large);
	    }
		@Override
		public void stateChanged(ChangeEvent e) {
			if (small == e.getSource()) {
				temp3 = 0;
			}else if(medium == e.getSource()) {
				temp3 = 1;
			}else {
				temp3 = 2;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(orderBtn == e.getSource()) {
			// �׼��̺�Ʈ ���� �ֹ� ��ư��
			price.setText(String.valueOf(sum));
			System.out.println("temp1: " + temp1 + " temp2: " + temp2+ " temp3: " + temp3 );
		}else if(cancelBtn == e.getSource()) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			price.setText(String.valueOf(sum));
		}
	}
	
}
