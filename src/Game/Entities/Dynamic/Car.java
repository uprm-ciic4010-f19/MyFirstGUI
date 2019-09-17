package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Car {

	private int xPos;
	private int yPos;
	private Color color;


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

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setPos(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public Color getColor() {
		return color;
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

	public void draw(Graphics g) {
		this.draw(g, this.getColor());
	}

	public void draw(Graphics g, Color color) {
		Graphics2D g2D = (Graphics2D) g;

		g2D.setColor(color);
		Rectangle body	= new Rectangle(this.getxPos()+10,this.getyPos()+20, 60, 10);
		g2D.fill(body);

		g2D.setColor(Color.BLACK);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(this.getxPos()+20, this.getyPos()+30, 10, 10);
		g2D.fill(rearTire);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.getxPos()+50, this.getyPos()+30, 10, 10);
		g2D.fill(frontTire);
		Line2D.Double rearWindow = new Line2D.Double(this.getxPos()+20, this.getyPos()+20, this.getxPos()+30, this.getyPos()+10);
		g2D.draw(rearWindow);
		Line2D.Double frontWindow = new Line2D.Double(this.getxPos()+60, this.getyPos()+20, this.getxPos()+50, this.getyPos()+10);
		g2D.draw(frontWindow);
		Line2D.Double roof = new Line2D.Double(this.getxPos()+30, this.getyPos()+10, this.getxPos()+50, this.getyPos()+10);
		g2D.draw(roof);
	}

//	public void draw(Graphics g, Color color) {
//		Graphics2D g2D = (Graphics2D) g;
//
//		// Original Size 90x225
//		double scale = 0.5;
//		double x = this.getxPos()/scale;
//		double y = this.getyPos()/scale;
//		g2D.scale(scale, scale);
//		// Tires and axis
//		g2D.setColor(Color.BLACK);
//		g2D.fill(new RoundRectangle2D.Double(x+6,y+39, 15, 33, 5, 5));
//		g2D.fill(new RoundRectangle2D.Double(x+69,y+39, 15, 33, 5, 5));
//		g2D.fill(new RoundRectangle2D.Double(x+3,y+156, 15, 33, 5, 5));
//		g2D.fill(new RoundRectangle2D.Double(x+72,y+156, 15, 33, 5, 5));
//		g2D.fill(new Rectangle2D.Double(x+21,y+54, 48, 3));
//
//		// Floor
//		g2D.setColor(new Color(39, 39, 39)); // Gray Metallic 40%
//		g2D.fill(new Rectangle2D.Double(x+15,y+117, 60, 81));
//		// Front Wing
//		g2D.setColor(this.getColor().brighter()); // Brighter
//		g2D.fill(new Rectangle2D.Double(x,y, 90, 27));
//		// Monocoque
//		g2D.setColor(this.getColor().darker()); // Darker
//		g2D.fill(new Rectangle2D.Double(x+33,y+27, 12, 90));
//		g2D.setColor(this.getColor().brighter()); // Brighter
//		g2D.fill(new Rectangle2D.Double(x+45,y+27, 12, 90));
//		// Engine Cover
//		g2D.setColor(this.getColor().darker()); // Darker
//		g2D.fill(polygon2D(new double[]{x+15, x+45, x+45}, new double[]{y+117, y+117, y+198}, 3));
//		g2D.setColor(this.getColor().brighter()); // Brighter
//		g2D.fill(polygon2D(new double[]{x+45, x+45, x+75}, new double[]{y+117, y+198, y+117}, 3));
//		// Exhaust Cover
//		g2D.setColor(new Color(39, 39, 39)); // Gray Metallic 40%
//		g2D.fill(new Ellipse2D.Double(x+36, y+123, 18, 75));
//		// Driver Seat
//		g2D.setColor(new Color(154, 176, 196)); // Blue Swaters 80%
//		g2D.fill(new Ellipse2D.Double(x+30, y+108, 30, 30));
//		// Tuning Vane
//		g2D.setColor(this.getColor().darker()); // Darker
//		g2D.fill(polygon2D(new double[]{x+45, x+15, x+45}, new double[]{y+117, y+117, y+102}, 3));
//		g2D.setColor(this.getColor().brighter()); // Brighter
//		g2D.fill(polygon2D(new double[]{x+45, x+75, x+45}, new double[]{y+102, y+117, y+117}, 3));
//		// Earwing
//		g2D.setColor(this.getColor().darker()); // Darker
//		g2D.fill(new Rectangle2D.Double(x+15,y+177, 30, 15));
//		g2D.setColor(this.getColor().brighter()); // Brighter
//		g2D.fill(new Rectangle2D.Double(x+45,y+177, 30, 15));
//		// Front Wing Flat
//		g2D.setColor(new Color(39, 39, 39)); // Gray Metallic 40%
//		g2D.fill(new Rectangle2D.Double(x+6,y+9, 78, 18));
//		// Rear Wing
//		g2D.setColor(this.getColor().brighter()); // Brighter
//		g2D.fill(new Rectangle2D.Double(x+5,y+198, 80, 25)); // Back
//		g2D.setColor(this.getColor().darker()); // Darker
//		g2D.fill(new Rectangle2D.Double(x+5,y+198, 80, 15)); //Upper
//
//		g2D.scale(1.0/scale, 1.0/scale);
//
//	}
//
//	public static Path2D.Double polygon2D(double[] xpoints, double[] ypoints, int npoints) {
//		Path2D.Double poly = new Path2D.Double();
//
//		poly.moveTo(xpoints[0], ypoints[0]);
//		for(int i = 1; i < xpoints.length; ++i) {
//			poly.lineTo(xpoints[i], ypoints[i]);
//		}
//		poly.closePath();
//		return poly;
//
//	}

}
