package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class Ball {
	private  Game game;
	private Point2D position;
	private Point2D velocity;
	private double angle;
	private final double gap = 40;
	private final double batWidth = 20;		
	private double size;
	
	public Ball(Game game, Point2D position, Point2D velocity, double size, int angle) {
		this.game = game;
		this.position = position;
		this.velocity = velocity;
		this.angle = angle;
		this.size = size;
		
	}
	
	public void draw(GraphicsContext gc) {
		//gc.save(); //save current state
		gc.setFill(Color.GRAY);
		Point2D p = game.transform2Canvas(position);
		gc.fillRect(p.getX(), p.getY(), size, size);
		//gc.restore(); //undone changes avoidind subseq drawing
	}
	
	public void simulate(double deltaT) {
		position = position.add(velocity);
		//System.out.println("Position: " + position);
	
		
		if (position.getX() < gap + batWidth || position.getX() > game.getWidth() - (gap + size + batWidth) ){
			velocity = velocity.multiply(-1);
		}
	}
}
