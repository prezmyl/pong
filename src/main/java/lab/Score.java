package lab;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Point2D;

public class Score {
	
	private final World world;
	private int score;
	private Point2D position;

	
	
	public Score(World world, Point2D position, int score) {
		this.score = score;
		this.position = position;
		this.world = world;
	}
	
	public void renderScore(GraphicsContext gc) {
		gc.setFont(Font.font("Arial", FontWeight.BOLD, 80));
	    gc.setFill(Color.GREY);
	    
	    Point2D p = world.transform2Canvas(position);
	    String scoreTxt = "" + score;
	    gc.fillText(scoreTxt, p.getX(), p.getY()); // Adjust position as needed
	}

}
