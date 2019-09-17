package Main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		JFrame mainFrame = new JFrame("My First Swing GUI");
		
		mainFrame.setSize(600, 400);
		
		MyComponent myComponent = new MyComponent();
		mainFrame.add(myComponent);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

		
		while(true) {
			
			mainFrame.repaint();
			
			Thread.sleep(1000/30);
			
		}
	}

}
