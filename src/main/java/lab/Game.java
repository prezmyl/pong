package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game {

	private final double width;
	private final double height;
	private final Bat bat1;
	
	public Game(double width, double height) {
		this.width = width;
		this.height = height;
		this.bat1 = new Bat(this, new Point2D(0,0), new Point2D(0,0));
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0 , width, height);
		
		gc.save();
		this.bat1.draw(gc);
		gc.restore();
	}
	
	//prijima objekt point a vrati novy objekt point s polohou vuci canvasu
	public Point2D transform2Canvas(Point2D p) {
		return new Point2D(p.getX(), height - p.getY());
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
