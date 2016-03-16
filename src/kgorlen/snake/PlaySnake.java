package kgorlen.snake;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PlaySnake extends Application {

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
