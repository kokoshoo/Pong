package pong;

import java.awt.Dimension;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainApplet app = new MainApplet();
		JFrame frame = new JFrame("Pong");
		frame.setPreferredSize(new Dimension(620,440));
		frame.setContentPane(app);
		frame.pack();
		frame.setVisible(true);
		app.init();
		app.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
