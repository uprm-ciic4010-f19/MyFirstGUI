package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

import Game.Entities.Dynamic.Car;

public class MyComponent extends JComponent{
	
	Random myRandGen = new Random();
	private static int counter = 0; // repaints counter
	
	public static final int NUM_CARS = 10;
	public Car[] theCars = new Car[NUM_CARS];
	public static Color[] colors = {Color.BLUE, Color.DARK_GRAY, Color.CYAN, Color.GREEN,
			Color.ORANGE, Color.MAGENTA};
	
	
	public MyComponent() {
		int lane = 0;
		for (int i=0; i< theCars.length; i++) {
			theCars[i]= new Car(0,lane,colors[myRandGen.nextInt(6)], 8);
			//theCars[i]= new Car(0,lane,colors[i%6], 13);
			lane+=50;
		}
		//theCars[1] = new Car(0,50,Color.GREEN, 8);
	}
	
	private boolean reachedRightEdge(Car c) {
		return (c.getDirection()>0 &&
				c.getxPos()+c.getWidth() >= this.getWidth());
	}
	
	private boolean reachedLeftEdge(Car c) {
		return (c.getDirection()<0 && c.getxPos()<=0);
	}
	
	public boolean someCarReachedLeftEdge() {
		for (Car c : theCars) {
			if (reachedLeftEdge(c))
				return true;
		}
		return false;
	}
	
	// Re-paints car in new x-position every "tick"
	public void paintComponent(Graphics g) {

		for(int i= 0; i < theCars.length; i++) {
			//theCars[i].move(theCars[i].getSpeed()*theCars[i].getDirection(), 0);
			
			theCars[i].move(myRandGen.nextInt(theCars[i].getSpeed()) *
					theCars[i].getDirection(), 0);

			if (reachedRightEdge(theCars[i])) //|| reachedLeftEdge(theCars[i]))
			{
				theCars[i].setDirection(theCars[i].getDirection()*-1); // Toggle direction
			}
			
			theCars[i].draw(g);
		}
		
		counter++;
		System.out.println("paintComponent called " + counter + " times.");

	}
	



}
