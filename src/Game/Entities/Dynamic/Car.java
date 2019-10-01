package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Car {

	private int xPos;
	private int yPos;
	private Color color;
	private int speed;  // Car speed in pixels per second
	private int direction=1; // 1=left to right, -1=right to left


	public Car(int xPos, int yPos, Color color, int speed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
		this.speed = speed;
	}

	public Car(int xPos, int yPos, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
	}

	public Car(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = Color.BLUE;
	}

	public int getxPos() {return xPos;}
	public int getyPos() {return yPos;}
	public int getSpeed() {return speed;}
	public Color getColor() {return color;}
    public int getDirection() {return direction;}
	public int getWidth() {return 60;}
	public int getHeight() {return 40;}

	public void setPos(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void move(int deltax, int deltay) {
		this.xPos = this.getxPos() + deltax;
		this.yPos = this.getyPos() + deltay;
	}

	public void draw(Graphics g) {
		this.draw(g, this.getColor());
	}

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

}
