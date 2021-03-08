package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Anima extends JPanel implements ActionListener{
	private Timer timer;
	private BufferedImage img;
	private final int start_x = 0;
	private final int start_y = 250;
	private int x,y;
	
	public Anima() {
		this.setBackground(Color.black);
	    this.setPreferredSize(new Dimension(500, 300));
	    this.setDoubleBuffered(true);
	    
	    File space = new File("image/space.jpg");
	    System.out.println(space.getAbsolutePath());
	    try {
	    	img = ImageIO.read(space);
	    }catch(IOException e) {
	    	e.printStackTrace();
	    	System.exit(1);
	    }
	    
		   x = start_x;
		   y = start_y;
		   
	    timer = new Timer(10, this);
	    timer.start();
	    
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, x, y, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//이미지에  x,y 좌표를 적절히 변경 > repaint();
		
		x += 1;
		y -= 1;
//		if(x > 500) {
//			x = start_x;
//			y = start_y;
//		}
		
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new Anima());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Space Animation");
		f.setSize(500, 300);

		f.setVisible(true);
	}

}
