package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class PoliceCar extends Car {

	public PoliceCar(int xPos, int yPos, Color color, int speed) {
		super(xPos, yPos, color, speed);
	}

	public PoliceCar(int xPos, int yPos, Color color) {
		super(xPos, yPos, color);
	}

	public PoliceCar(int xPos, int yPos) {
		super(xPos, yPos);
	}

	public void draw(Graphics g) {
		this.draw(g, this.getColor());
	}

	public void draw(Graphics g, Color color) {
		Graphics2D g2D = (Graphics2D) g;
		
		super.draw(g, color);
		
		// Biombo
		Ellipse2D.Double biombo = new Ellipse2D.Double(this.getxPos()+40, this.getyPos(), 5, 5);
		g2D.setColor(Color.BLUE);		
		g2D.fill(biombo);				

	}
}


