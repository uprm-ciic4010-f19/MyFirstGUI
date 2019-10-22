package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public abstract class Vehicle {

	private int xPos;
	private int yPos;
	private Color color;
	private int speed;  // Car speed in pixels per second
	private int direction=1; // 1=left to right, -1=right to left


	public Vehicle(int xPos, int yPos, Color color, int speed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
		this.speed = speed;
	}

	public Vehicle(int xPos, int yPos, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
	}

	public Vehicle(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = Color.BLUE;
	}

	public int getxPos() {return xPos;}
	public int getyPos() {return yPos;}
	public int getSpeed() {return speed;}
	public Color getColor() {return color;}
    public int getDirection() {return direction;}
	public abstract int getWidth();
	public abstract int getHeight();

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

	public abstract void draw(Graphics g, Color color);


}
