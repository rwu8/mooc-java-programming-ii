package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

	public static void main(String[] args) {
		launch(JokeApplication.class);
	}

	@Override
	public void start(Stage window) throws Exception {
		//1. Set the main window
		BorderPane layout = new BorderPane();

		//1.1 Set the layout for menu
		HBox horizontalMenu = new HBox();
		horizontalMenu.setAlignment(Pos.CENTER);
		horizontalMenu.setSpacing(20);
		horizontalMenu.setPadding(new Insets(20,20,20,20));
		Button joke = new Button("Joke");
		Button answer = new Button("Answer");
		Button explanation = new Button("Explanation");

		//1.2 Add the elements to the layout
		horizontalMenu.getChildren().addAll(joke, answer, explanation);

		//2. Set the look of the differnt views
		StackPane jokeScreen = createView("What do you call a bear with no teeth?");
		StackPane answerScreen = createView("A gummy bear.");
		StackPane explanationScreen = createView("N/A");

		//3. Give the button actions
		joke.setOnAction((event) -> layout.setCenter(jokeScreen));
		answer.setOnAction((event) -> layout.setCenter(answerScreen));
		explanation.setOnAction((event) -> layout.setCenter(explanationScreen));

		//4. Set the default view
		layout.setTop(horizontalMenu);
		layout.setCenter(jokeScreen);

		//5. Create a scene
		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.show();


	}

	private StackPane createView(String text){
		StackPane layout = new StackPane();
		layout.setPrefSize(400, 400);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(new Label(text));

		return layout;
	}
}
