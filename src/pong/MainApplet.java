package pong;

import javax.swing.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainApplet extends Applet implements Runnable{
	Player p1,p2;
	Ball ball;
	Thread runner;
	//Scores
	int sc1 = 0;
	int sc2 = 0;
	
	
	public void init(){
		p1 = new Player(0,160,10,40);
		p2 = new Player(590,160,10,40);
		ball = new Ball(293,193,5,5);
		
		//Add listener for movement
		addKeyListener(p1);
		this.setFocusable(true);
		this.setSize(600,400);
	    runner = null;
		
	}
	public void start(){
		if(runner == null){
			runner = new Thread(this);
			runner.start();
		}
		
	}
	
	public void stop(){
		if(runner != null){
			runner = null;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			start();
		}
	}
	
	public boolean collision(){
		if(p1.getBounds().intersects(ball.getBounds())){
			if(ball.xspeed<0){
				System.out.println("hit p1 paddle");
				ball.reverse();
				return true;
			}
			return false;
		}
		if(p2.getBounds().intersects(ball.getBounds())){
			if(ball.xspeed>0){
				System.out.println("hit p2 paddle");
				ball.reverse();
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void paint(Graphics g){
		//Paint background
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 400);
		
		//Paint ball
		g.setColor(Color.pink);
		g.fillRect(ball.getX(), ball.getY(), ball.getW(), ball.getH());
		
		//Draw score
		g.drawString(Integer.toString(sc1), 40, 40);
		g.drawString(Integer.toString(sc2), 540, 40);
		
		//Paint player one
		g.setColor(Color.red);
		g.fillRect(p1.getX(), p1.getY(), p1.getW(), p1.getH());
		//Paint player two
		g.setColor(Color.blue);
		g.fillRect(p2.getX(), p2.getY(), p2.getW(), p2.getH());


		
	}
	
	public void scored(){
		if(ball.x>600){
			sc1++;
			System.out.println("player 1 scored: " + sc1);
			ball.reset();
			stop();
		}
		else if(ball.x< 0){
			sc2++;
			System.out.println("player 2 scored: " + sc2);
			ball.reset();
			stop();
		}
	}
	
	
	public void update(Graphics g){
		//double buffering, use second image to relay the images properly so no image is left behind
		Graphics gc;
		Image offscreen = null;

		@SuppressWarnings("deprecation")
		Dimension d = size();
		
		offscreen = createImage(d.width,d.height);
		gc = offscreen.getGraphics();
		gc.setColor(getBackground());
		gc.fillRect(0, 0, d.width, d.height);
		gc.setColor(getForeground());
		paint(gc);
		g.drawImage(offscreen,0,0,this);
	}
	

	public void update(){
		//Check collisions
		collision();
		
		//Update graphics
		repaint();
		
		//Allow player one to move with up and down
		p1.move();
		
		//Keep the ball moving
		ball.move();
		
		//Check if a player scored
		scored();
		
		
		//Keep the computer following the ball
		p2.follow(ball.y);
	}
	
	@Override
	public void run() {
		while(runner!=null){
			update();
			try {
				Thread.sleep(20);
				//System.out.println(p1.y);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}