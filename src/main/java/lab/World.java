package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class World {
	
	private final double width;
	private final double height;
	private final double gap = 40;
	private final double lineWidth = 20;
	private final double paddleHeight = 100;
	
	private final Rectangle ball;
	private final Rectangle paddle1;
	private final Rectangle paddle2;
	private final Rectangle lineUp;
	private final Rectangle lineDown;
	private final Rectangle[] lineCenter;
	private final int objectNum = 15;
	
	private final Score score1;
	private final Score score2;
	
	

	
	public World(double width, double height) {
		this.width = width;
		this.height = height;
		
		this.ball = new Rectangle(this, new Point2D(width/2 + lineWidth/2 +  2 * gap, height/2 + 4 * gap),lineWidth,lineWidth);
		this.paddle1 = new Rectangle(this, new Point2D(gap,height/2 + 3 * gap),lineWidth, paddleHeight);
		this.paddle2 = new Rectangle(this, new Point2D(width - (gap + lineWidth), height/2 + paddleHeight/2),lineWidth,paddleHeight);
		
		this.lineUp = new Rectangle(this, new Point2D(0,height),width, lineWidth);
		this.lineDown = new Rectangle(this, new Point2D(0,lineWidth),width, lineWidth);
		
		this.lineCenter = new Rectangle[objectNum];
		for (int i = 0; i < objectNum; i++){
			this.lineCenter[i] = new Rectangle(this, new Point2D(width/2 - lineWidth/2, lineWidth + i * 2 * lineWidth),lineWidth,lineWidth);
		}
		
		this.score1 = new Score(this, new Point2D(width/2 - 2.5 * gap, height - 2.5 * gap), 4);
		this.score2 = new Score(this, new Point2D(width/2 +  1.5 * gap, height - 2.5 * gap), 0);
	}
	
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, width, height);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0 , width, height);
		this.ball.draw(gc);
		this.paddle1.draw(gc);
		this.paddle2.draw(gc);
		this.lineUp.draw(gc);
		this.lineDown.draw(gc);
		for (int i = 0; i < objectNum; i++){
			this.lineCenter[i].draw(gc);
		}
		
		this.score1.renderScore(gc);
		this.score2.renderScore(gc);
		
	}
	
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
