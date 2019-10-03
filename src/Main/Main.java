package Main;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		JFrame mainFrame = new JFrame("My First Swing GUI");
		
		mainFrame.setSize(700, 700);
		
		MyComponent myComponent = new MyComponent();
		mainFrame.add(myComponent);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

		


		while(!myComponent.winner()) {
			

			mainFrame.repaint();
			Thread.sleep(1000/30);
		}
		
		myComponent.doesCarColorExist(Color.BLACK);
		myComponent.maxSpeed();
		//myComponent.avgSpeed(); // Students try to complete this method.
		
	}

}
