package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bat {
		
	private final Game game;
	private final double sizeY;
	private final double sizeX;
	
	private Point2D position;
	private Point2D velocity;
	//private Point2D acceleration;
	//private Point2D velocity;
	
	public Bat(Game game, Point2D position, Point2D velocity, double sizeX, double sizeY) {
		this.position = position;
		this.velocity = velocity;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.game = game;
	
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.GRAY);
		Point2D p = game.transform2Canvas(position);
		gc.fillRect(p.getX(), p.getY(), sizeX, sizeY);
	}
	
	public void simulate(double deltaT) {
		position = position.add(velocity).multiply(deltaT));	
		position = new Point2D(position.getX() + game.getWidth(), position.getY());
		
	}
	
	protected Game getGame() {
		return game;
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
