package kgorlen.snake;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PlaySnake extends Application {
//    public static final double SPEED_MS = 100;
//	public static final int CELL_SIZE = 10;
//	public static final int ROWS = 30;
//	public static final int COLUMNS = 30;
//	public static final int GRID_WIDTH = COLUMNS * CELL_SIZE;
//    public static final int GRID_HEIGHT  = ROWS * CELL_SIZE;
//    public static final int SCORE_HEIGHT = 30;
//    public static final int BORDERPANE_WIDTH = GRID_WIDTH + 2*CELL_SIZE;
//    public static final int BORDERPANE_HEIGHT = CELL_SIZE + GRID_HEIGHT + SCORE_HEIGHT;
//    public static final Point UPPERLEFT = new Point(0,0);
//    public static final Point LOWERRIGHT = new Point(GRID_WIDTH-1, GRID_HEIGHT-1);		

	public static void main(String[] args) {
		launch(PlaySnake.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("snake.fxml"));
			Parent root = fxmlLoader.load();	// Calls SnakeController.initialize()
			SnakeController snakeController = fxmlLoader.getController();
// setResizeable(false) changes the size of the stage: https://bugs.openjdk.java.net/browse/JDK-8089008
//			primaryStage.setResizable(false);	
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("snake.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Snake");
			primaryStage.show();
			snakeController.handleMouseEntered(null);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
