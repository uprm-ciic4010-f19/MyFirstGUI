package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Truck extends Vehicle {

	public Truck(int xPos, int yPos, Color color, int speed) {
		super(xPos, yPos, color, speed);
	}

	public Truck(int xPos, int yPos, Color color) {
		super(xPos, yPos, color);
	}

	public Truck(int xPos, int yPos) {
		super(xPos, yPos);
	}
	@Override
	public int getWidth() {
		return 60;
	}

	@Override
	public int getHeight() {
		return 30;
	}

	@Override
	public void draw(Graphics g, Color color) {
		Graphics2D g2D = (Graphics2D) g;
		Rectangle cargo;
		Line2D.Double frontWindow;
		Ellipse2D.Double headLight;
		Ellipse2D.Double tailLight;
		
		if (this.getDirection() > 0) {
			cargo = new Rectangle(this.getxPos()+10,this.getyPos(), 40, 30);
			frontWindow = new Line2D.Double(this.getxPos()+60, this.getyPos()+20, this.getxPos()+50, this.getyPos()+10);
			tailLight = new Ellipse2D.Double(this.getxPos()+10, this.getyPos()+20, 5, 5);
			headLight = new Ellipse2D.Double(this.getxPos()+65, this.getyPos()+20, 5, 5);
		} else {
			cargo = new Rectangle(this.getxPos()+30,this.getyPos(), 40, 30);
			frontWindow = new Line2D.Double(this.getxPos()+20, this.getyPos()+20, this.getxPos()+30, this.getyPos()+10);
			headLight = new Ellipse2D.Double(this.getxPos()+10, this.getyPos()+20, 5, 5);
			tailLight = new Ellipse2D.Double(this.getxPos()+65, this.getyPos()+20, 5, 5);
		}

		// BODY
		g2D.setColor(color);
		Rectangle body	= new Rectangle(this.getxPos()+10,this.getyPos()+20, 60, 10);
		g2D.fill(body);
		g2D.setColor(color.darker());
		g2D.fill(cargo);
		// OTHER CAR PARTS
		Ellipse2D.Double rearTire = new Ellipse2D.Double(this.getxPos()+20, this.getyPos()+30, 10, 10);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.getxPos()+50, this.getyPos()+30, 10, 10);
		g2D.setColor(Color.BLACK);

		g2D.fill(rearTire);		
		g2D.fill(frontTire);		
		//	g2D.draw(rearWindow);		
		g2D.draw(frontWindow);		
		//	g2D.draw(roof);
		// LIGHTS
		g2D.setColor(Color.YELLOW);
		g2D.fill(headLight);
		g2D.setColor(Color.RED);
		g2D.fill(tailLight);

	}

	@Override
	public String greet() {
		return "Autobots, roll out";
	}

}
