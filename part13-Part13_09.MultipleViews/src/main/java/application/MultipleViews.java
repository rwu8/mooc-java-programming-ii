package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

	public static void main(String[] args) {
		launch(MultipleViews.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox vBox = new VBox();
		BorderPane borderPane = new BorderPane();

		Label firstText = new Label("First view!");
		Button firstButtonNext = new Button("To the second view!");
		borderPane.setTop(firstText);
		borderPane.setCenter(firstButtonNext);

		Button secondButtonNext = new Button("To the third view!");
		Label secondText = new Label("Second view!");
		vBox.getChildren().addAll(secondButtonNext, secondText);

		GridPane gridPane = new GridPane();
		Button thirdButtonNext = new Button("To the first view!");
		Label thirdText = new Label("Third View");
		gridPane.add(thirdText, 0, 0);
		gridPane.add(thirdButtonNext, 1, 1);

		Scene first = new Scene(borderPane);
		Scene second = new Scene(vBox);
		Scene third = new Scene(gridPane);

		firstButtonNext.setOnAction((event) -> {
			stage.setScene(second);
		});

		secondButtonNext.setOnAction((event) -> {
			stage.setScene(third);
		});

		thirdButtonNext.setOnAction((event) -> {
			stage.setScene(first);
		});

		stage.setScene(first);
		stage.show();
	}

}
