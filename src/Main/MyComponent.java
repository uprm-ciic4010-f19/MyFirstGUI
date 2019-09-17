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
	
	public Car f1Car = new Car(10, 10,Color.BLUE);
	public Car f2Car = new Car(0,0, Color.RED);
	public Car f3Car = new Car(0,0);
	
	public void paintComponent(Graphics g) {
		
		f1Car.draw(g);
		
		f2Car.setPos(this.getWidth()-80, this.getHeight()-40);
		f2Car.draw(g);
		
		Random genRan = new Random();
		f3Car.setColor(Color.MAGENTA);
		f3Car.setPos(genRan.nextInt(this.getWidth()-80), genRan.nextInt(this.getHeight()-40));
		f3Car.draw(g);
		
//		drawCar(g, 10, 10);
//		drawCar(g, 200, 200);
//		drawCar(g, this.getWidth()-80, this.getHeight()-40);
		
		counter++;
		System.out.println("paintComponent called " + counter + " times.");
		
	}
	
	
}