package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game {

	private final double width;
	private final double height;
	private final Bat bat1, bat2;
	private final double sizeBatX = 20;
	private final double sizeBatY = 100;
	private final Ball ball;
	private double sizeBall = 20;
	private int angle = 15;
	private final double lineWidth = 20;
	
	private final double gap = 40;
	
	public Game(double width, double height) {
		this.width = width;
		this.height = height;
		this.bat1 = new Bat(this, new Point2D(gap, sizeBatY + lineWidth), new Point2D(0,4.5), sizeBatX, sizeBatY);
		this.bat2 = new Bat(this, new Point2D(width - (gap + sizeBatX), height - lineWidth), new Point2D(0,-4.5), sizeBatX, sizeBatY);
		this.ball = new Ball(this, new Point2D(width/2 - sizeBall/2 ,height/2), new Point2D(6.41,0), sizeBall, angle);
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0 , width, height);
		//gc.clearRect(0, 0, width, height);
		//gc.save();
		this.bat1.draw(gc);
		this.bat2.draw(gc);
		this.ball.draw(gc);
		//gc.restore();
	}
	
	public void simulate(double deltaT) {
		this.bat1.simulate(deltaT);
		this.bat2.simulate(deltaT);
		this.ball.simulate(deltaT);
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
