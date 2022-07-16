import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel implements KeyListener{
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	Block paddle;
	Thread thread;
	Animate animate;
	
	//all the in-game blocks
	BlockBreakerPanel(){
		
		paddle = new Block(175, 480, 150, 25, "paddle.png");
		for(int i=0; i<8; i++) {
			blocks.add(new Block((i*60+2), 0, 60, 25, "blue.png"));
		}
		for(int i=0; i<8; i++) {
			blocks.add(new Block((i*60+2), 25, 60, 25, "red.png"));
		}
		for(int i=0; i<8; i++) {
			blocks.add(new Block((i*60+2), 50, 60, 25, "green.png"));
		}
		for(int i=0; i<8; i++) {
			blocks.add(new Block((i*60+2), 75, 60, 25, "yellow.png"));
		}
		
		//without these lines it wont listen for keys
		addKeyListener(this);
		setFocusable(true);
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		for(Block b : blocks)
			b.draw(g,  this);
		paddle.draw(g, this);
	}
	
	public void update() {
		repaint();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			animate = new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.x-=15;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.x+=15;			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
