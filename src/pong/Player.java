package pong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player implements KeyListener{
int x = 0;
int y = 0;
int w = 0;
int h = 0;
boolean up = false;
boolean down = false;
	public Player(int X, int Y, int W, int H){
		x = X;
		y = Y;
		w = W;
		h = H;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public int getW(){
		return w;
	}
	
	public int getH(){
		return h;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(getX(),getY(),getW(),getH());
	}
	
	public void move(){
		if(up==true){
			y-=6;
		}
		if(down==true){
			y+=6;
		}
	}
	
	public void follow(int i){
		y = i;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			up = true;
		}
		if(key == KeyEvent.VK_DOWN){
			down = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			up = false;
		}
		if(key == KeyEvent.VK_DOWN){
			down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
