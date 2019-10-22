package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Car extends Vehicle {
	
	private String name;

	public Car(int xPos, int yPos, Color color, int speed) {
		super(xPos, yPos, color, speed);
		name = "Player1";
	}

	public Car(int xPos, int yPos, Color color) {
		super(xPos, yPos, color);
		name = "Player1";
	}

	public Car(int xPos, int yPos) {
		super(xPos, yPos);
		name = "Player1";
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 30;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void draw(Graphics g, Color color) {
		Graphics2D g2D = (Graphics2D) g;
		// BODY
		g2D.setColor(color);
		Rectangle body	= new Rectangle(this.getxPos()+10,this.getyPos()+20, 60, 10);
		g2D.fill(body);
		// OTHER CAR PARTS
		Ellipse2D.Double rearTire = new Ellipse2D.Double(this.getxPos()+20, this.getyPos()+30, 10, 10);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.getxPos()+50, this.getyPos()+30, 10, 10);
		Line2D.Double rearWindow = new Line2D.Double(this.getxPos()+20, this.getyPos()+20, this.getxPos()+30, this.getyPos()+10);
		Line2D.Double frontWindow = new Line2D.Double(this.getxPos()+60, this.getyPos()+20, this.getxPos()+50, this.getyPos()+10);
		Line2D.Double roof = new Line2D.Double(this.getxPos()+30, this.getyPos()+10, this.getxPos()+50, this.getyPos()+10);
		g2D.setColor(Color.BLACK);		
		g2D.fill(rearTire);		
		g2D.fill(frontTire);		
		g2D.draw(rearWindow);		
		g2D.draw(frontWindow);		
		g2D.draw(roof);
		// LIGHTS
		Ellipse2D.Double leftLight = new Ellipse2D.Double(this.getxPos()+10, this.getyPos()+20, 5, 5);
		Ellipse2D.Double rightLight = new Ellipse2D.Double(this.getxPos()+65, this.getyPos()+20, 5, 5);
		if (this.getDirection() > 0) {
			g2D.setColor(Color.RED);
			g2D.fill(leftLight);
			g2D.setColor(Color.YELLOW);
			g2D.fill(rightLight);
		}
		else {
			g2D.setColor(Color.YELLOW);
			g2D.fill(leftLight);
			g2D.setColor(Color.RED);
			g2D.fill(rightLight);		}
	}

	@Override
	public String greet() {
		return "Hello, I'm " + this.getName();
	}

}
