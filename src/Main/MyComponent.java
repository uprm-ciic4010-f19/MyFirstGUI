package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JComponent;

import Game.Entities.Dynamic.Car;

public class MyComponent extends JComponent{
	
	
	Random myRandGen = new Random();

	private static int counter = 0;
	//public Car f1Car = new Car(0,0,Color.BLUE, 5);
	//public Car f2Car = new Car(0,50,Color.GREEN, 5);
	
	public static final int NUM_CARS = 10;
	public Car[] theCars = new Car[NUM_CARS];
	public static Color[] colors = {Color.BLUE, Color.DARK_GRAY, Color.CYAN, Color.GREEN,
			Color.ORANGE, Color.MAGENTA};
	
	
	public MyComponent() {
		int lane = 0;
		for (int i=0; i< theCars.length; i++) {
			//theCars[i]= new Car(0,lane,colors[myRandGen.nextInt(6)], 8);
			theCars[i]= new Car(0,lane,colors[i%6], 13);
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
		
//		theCars[1].move(theCars[1].getSpeed()*theCars[1].getDirection(), 0);
//		if (((theCars[1].getDirection()>0) && (theCars[1].getxPos()+theCars[1].getWidth() >= this.getWidth())) ||
//				((theCars[1].getDirection()<0) && (theCars[1].getxPos()<=0)))
//		{
//			theCars[1].setDirection(theCars[1].getDirection()*-1); // Toggle direction
//		}
//		theCars[1].draw(g);

		//		f3Car.move(f3Car.getSpeed(), 0);
		//		f3Car.draw(g);

		//		drawCar(g, 10, 10);
		//		drawCar(g, 200, 200);
		//		drawCar(g, this.getWidth()-80, this.getHeight()-40);

		counter++;
		System.out.println("paintComponent called " + counter + " times.");

	}
	
	public boolean someCarReachedLeftEdge() {
		for (Car c : theCars) {
			if (reachedLeftEdge(c))
				return true;
		}
		return false;
	}


}
