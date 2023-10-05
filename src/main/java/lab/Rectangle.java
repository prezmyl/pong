package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle {

	private final World world;
	private Point2D position;
	private double sizeX;
	private double sizeY;
	
	public Rectangle(World world, Point2D position, double sizeX, double sizeY) {
		this.world = world;
		this.position = position;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.GRAY);
		Point2D p = world.transform2Canvas(position);
		gc.fillRect(p.getX(), p.getY(), sizeX, sizeY);
	}
	
	
	protected World getWorld() {
		return world;
	}

	protected Point2D getPosition() {
		return position;
	}

	protected double getSizeX() {
		return sizeX;
	}
	
	protected double getSizeY() {
		return sizeY;
	}
}
