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
	public static final int MAX_SPEED = 10;
	public Car[] theCars = new Car[NUM_CARS];

	public static Color[] colors = {Color.BLUE, Color.DARK_GRAY, Color.CYAN, Color.GREEN,
			Color.ORANGE, Color.MAGENTA, Color.BLACK, Color.PINK};


	public MyComponent() {
		int lane = 0;
		for (int i=0; i < theCars.length; i++) {
			theCars[i]= new Car(0,lane,colors[myRandGen.nextInt(colors.length)],
					(myRandGen.nextInt(MAX_SPEED)+5));
			//theCars[i]= new Car(0,lane,colors[i%6], 13);
			lane += theCars[i].getHeight() + 10;
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


	public boolean winner() {
		for (Car c : theCars) {
			if (reachedLeftEdge(c))
				return true;
		}
		return false;
	}


	public boolean doesCarColorExist(Color clr) {
		for (Car c : theCars) {
			if(c.getColor() == clr) {
				System.out.println("True");
				return true;
			}
		}
		return false;
	}

	// Version at end of Oct-01 lecture 
//	public void maxSpeed() {
//		int max = theCars[0].getSpeed();
//		for (int i = 1; i < theCars.length; i++) {
//			if(theCars[i].getSpeed() > max) {
//				max = theCars[i].getSpeed();
//				System.out.println("Max speed is car: " + i);
//			}
//		}
//	}
	
	// Alternate Improved Version 
	public void maxSpeed() {
		int max = theCars[0].getSpeed();
		for (int i = 1; i < theCars.length; i++) {
			if(theCars[i].getSpeed() > max) {
				max = theCars[i].getSpeed();
			}
		}
		System.out.println("The fastest car has speed of : " + max);
	}	
	
	// Alternate Version with return
	public int getMaxSpeed() {
		int max = theCars[0].getSpeed();
		for (int i = 1; i < theCars.length; i++) {
			if(theCars[i].getSpeed() > max) {
				max = theCars[i].getSpeed();
			}
		}
		return max;
	}
}
