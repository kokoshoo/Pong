package pong;

import java.awt.*;

public class Ball {
	int x = 0;
	int y = 0;
	int w = 0;
	int h = 0;
	float xspeed = 2;
	float yspeed = 3;
		public Ball(int X, int Y, int W, int H){
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
		public void reverse(){
			if(xspeed<0){
				xspeed-=.1;
			}
			else if(xspeed>=0){
				xspeed+=.1;
			}
			if(yspeed<0){
				yspeed-=.1;
			}
			else if(yspeed>=0){
				yspeed+=.1;
			}
			xspeed = -xspeed;

			System.out.println("Ball: X Speed = " + Math.abs(xspeed) + " Y Speed = " + Math.abs(yspeed));	
		}
		
		public void move(){
			if(x>600-w){
				xspeed = -xspeed;
			}
			else if(x<0){
				xspeed = -xspeed;
			}
			if(y>400-h){
				yspeed = -yspeed;
			}
			else if(y<0){
				yspeed = -yspeed;
			}
				x+=xspeed;
				y+=yspeed;
		}
		
		public Rectangle getBounds(){
			return new Rectangle(getX(),getY(),getW(),getH());
		}
		public void reset(){
			x = 293;
			y = 193;
			xspeed = 2;
			yspeed = 3;
		}
}
