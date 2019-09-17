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
	
	private static int counter = 0;
	
//	public Car f1Car = new Car(10, 10,Color.BLUE);
	public Car f2Car = new Car(0,0,Color.MAGENTA, 20);
	public Car f3Car = new Car(0,30,Color.BLUE, 5);
	
	public void paintComponent(Graphics g) {
//		
//		f1Car.draw(g);
//		
//		f2Car.setPos(this.getWidth()-80, this.getHeight()-40);
//		f2Car.draw(g);
		
//		Random genRan = new Random();
//		f3Car.setColor(Color.MAGENTA);
		f2Car.setPos(f2Car.getxPos()+f2Car.getSpeed(), f2Car.getyPos());
		f2Car.draw(g);

		f3Car.setPos(f3Car.getxPos()+f3Car.getSpeed(), f3Car.getyPos());
		f3Car.draw(g);

//		drawCar(g, 10, 10);
//		drawCar(g, 200, 200);
//		drawCar(g, this.getWidth()-80, this.getHeight()-40);
		
		counter++;
		System.out.println("paintComponent called " + counter + " times.");
		
	}
	
	
}
