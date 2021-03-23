package ch13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PingPong2 extends JPanel implements KeyListener{
	protected Racquet racquet1;
	protected Racquet racquet2;
	Ball ball;
	Score score;
	Image img;
	private Graphics graphics;
	protected int player1;
	protected int player2;
	
	public PingPong2() {
		ball = new Ball(this, Color.white);
//		.setBackground(Color.green);
		racquet1 = new Racquet(this, 10, 150, Color.blue);
		racquet2 = new Racquet(this, 560, 150, Color.red);
		score = new Score(600, 400);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	void move() {
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racquet1.KeyReleased(e);
		racquet2.KeyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("PingPong Game");
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setBackground(Color.black);
		PingPong2 game = new PingPong2();
		f.add(game);
		f.setVisible(true);
		while(true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		// 이중버퍼링 사용
		img = createImage(getWidth(),getHeight());
		graphics = img.getGraphics();
		draw(graphics);
		g.drawImage(img, 0, 0, this);
//		super.paint(g);
//		Graphics2D g2d = (Graphics2D) g;
//		ball.draw(g2d);
//		racquet1.draw(g2d);
//		racquet2.draw(g2d);
//		score.draw(g2d);
	}
	
	public void draw(Graphics g) {
		ball.draw(g);
		racquet1.draw(g);
		racquet2.draw(g);
		score.draw(g);
	}
	
	// 라켓
	class Racquet extends Rectangle{
		private static final int WIDTH = 10;
		private static final int HEIGHT = 80;
		private int x = 0, y = 0;
		private int xSpeed = 0;
		private int ySpeed = 0;
		private PingPong2 game;
		private Color color;
		
		public Racquet (PingPong2 game, int x, int y, Color color) {
			this.game = game;
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public void draw(Graphics g) {
			g.setColor(color);
			g.fillRect(x, y, WIDTH, HEIGHT);
		}
		
		public void move() {
			if (y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT)
				y += ySpeed;
		}
		
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W)
				racquet1.ySpeed = -3;
			else if (e.getKeyCode() == KeyEvent.VK_S)
				racquet1.ySpeed = 3;
			
			if (e.getKeyCode() == KeyEvent.VK_UP)
				racquet2.ySpeed = -3;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				racquet2.ySpeed = 3;
		}
		
		public void KeyReleased(KeyEvent e) {
			ySpeed = 0;
		}

		public Rectangle getBounds() {
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
		
	}
	
	// 공
	class Ball extends Rectangle{
		public static final int RADIUS = 10;
		private int x = 0, y = 0, xSpeed = 2, ySpeed = 2;
		private PingPong2 game;
		private Color color;
		
		public Ball(PingPong2 game, Color color) {
			this.game = game;
			this.color = color;
		}
		
		
		public void draw(Graphics g) {
			g.setColor(color);
			g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
		}
		
		void move() {
			if (x + xSpeed < 0) {
				xSpeed = 2;
				player2 += 1; // 왼쪽 벽에 부딪혔을때 player2 점수추가
			}
			if (x + xSpeed > game.getWidth() - 2 * RADIUS) {
				xSpeed = -2;
				player1 += 1; // 오른쪽 벽에 부딪혔을때 player2 점수추가
			}
			if (y + ySpeed < 0)
				ySpeed = 2;
			if (y + ySpeed > game.getHeight() - 2 * RADIUS)
				ySpeed = -2;
			if(collision())
				xSpeed = -xSpeed;
			x += xSpeed;
			y += ySpeed;
		}
		
		// 공의 충돌반응
		private boolean collision() { // collision = 충돌
			// intersects : 겹치는 부분
			boolean r1c = game.racquet1.getBounds().intersects(getBounds());
		    boolean r2c = game.racquet2.getBounds().intersects(getBounds());
//		    Rectangle r1 = game.racquet1.getBounds();
//		    Rectangle r2 = game.racquet2.getBounds();
//		    Rectangle myr = getBounds();
//		    boolean r1c = r1.intersects(myr);
//		    boolean r2c = r2.intersects(myr);
		    // 둘 중에 하나라도 겹치는 부분이 있으면 true;
		    
		    return r1c || r2c;
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
		}
	}

	public class Score{
		private int GAME_WIDTH;
		private int GAME_HEIGHT;
//		protected int player1;
//		protected int player2;
		
		public Score(int gameWidth, int gameHeight) {
			GAME_WIDTH = gameWidth;
			GAME_HEIGHT = gameHeight;
		}
		
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
			
			g.drawLine(GAME_WIDTH/2,0,  GAME_WIDTH/2, GAME_HEIGHT);
			
			g.drawString(String.valueOf(player1/10)+ String.valueOf(player1%10), GAME_WIDTH/2 - 85, 50);
			g.drawString(String.valueOf(player2/10)+ String.valueOf(player2%10), GAME_WIDTH/2 + 20, 50);
		}
	}
}
