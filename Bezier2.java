package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;

import javax.swing.*;

public class Bezier2 extends JFrame implements MouseListener, MouseMotionListener{
	private int xs[] = {50, 150, 400, 450};
	private int ys[] = {200 , 50, 300, 200};
	private Draw d;
	private int dragIndex = -1;
	
	public Bezier2() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("º£Áö¾î");
		d = new Draw();
		d.addMouseListener(this);
		d.addMouseMotionListener(this);
		this.add(d);
		this.setVisible(true);
	}
	
	class Draw extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(Color.blue);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		
		g.setColor(Color.red);
		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		GeneralPath p = new GeneralPath();
		p.moveTo(xs[0], ys[0]);
		p.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
		g2d.draw(p);
	    }

	}
	
	public static void main(String[] args) {
		new Bezier2();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) {
		dragIndex = -1;
		
		for(int i = 0; i < 4; i++) {
			Rectangle r = new Rectangle(xs[i] -4, ys[i] -4, 20, 20);
			if(r.contains(e.getX(), e.getY()))
			    dragIndex = i;
		    }
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragIndex = -1;
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		if(dragIndex != -1) {
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

}
