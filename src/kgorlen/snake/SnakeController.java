package kgorlen.snake;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SnakeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="rootPane"
    private BorderPane rootPane; // Value injected by FXMLLoader

    @FXML // fx:id="canvas"
    private Canvas canvas; // Value injected by FXMLLoader

    @FXML // fx:id="score"
    private Text score; // Value injected by FXMLLoader

    public static final double SPEED_MS = 100;
	public static int CELL_SIZE;
	public static int ROWS;
	public static int COLUMNS;
	public static Bounds GRID_BOUNDS;

    private Snake snake;
    private Apple apple;
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'snake.fxml'.";
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'snake.fxml'.";
        assert score != null : "fx:id=\"score\" was not injected: check your FXML file 'snake.fxml'.";

        CELL_SIZE = (int) Math.round(rootPane.getTop().getBoundsInParent().getHeight());
        GRID_BOUNDS = rootPane.getCenter().getBoundsInParent();
        ROWS = (int) Math.floor(GRID_BOUNDS.getHeight() / CELL_SIZE);
        COLUMNS = (int) Math.floor(GRID_BOUNDS.getWidth() / CELL_SIZE);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
	    snake = new Snake(gc);
	    apple = new Apple(gc);
        apple.move(snake);

    	Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(SPEED_MS),
                  new EventHandler<ActionEvent>() {
                    // KeyFrame event handler
                    public void handle(ActionEvent event) {
                    	if (!snake.addHead() || snake.eats(apple)) {
                        	score.setText("Score: " + snake.getScore());
                            apple.move(snake);
                    	}
                    }
                }));
        timeline.playFromStart();
    }

    @FXML
    void handleKeyPressed(KeyEvent event) {
		snake.keyPressed(event);    	
    }

    @FXML
    void handleMouseEntered(MouseEvent event) {
    	rootPane.requestFocus();
    }
    
}