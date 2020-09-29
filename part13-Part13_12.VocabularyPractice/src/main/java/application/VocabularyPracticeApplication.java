package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application{

	private Dictionary dictionary;


	public static void main(String[] args) {
		launch(VocabularyPracticeApplication.class);
	}

	@Override
	public void init() throws Exception{
		//creates the first dictionary
		dictionary = new Dictionary();
	}

	@Override
	public void start(Stage window) throws Exception {
		//Import the views from the classes we created
		PracticeView practiceView = new PracticeView(dictionary);
		InputView inputView = new InputView(dictionary);

		//Sets an overarching layout that will include the different views
		BorderPane layout = new BorderPane();

		//Sets and styles the main navigation of the application
		HBox menu = new HBox();
		menu.setPadding(new Insets(10, 10, 10, 10));
		menu.setSpacing(10);

		Button practiceButton = new Button("Practice");
		Button inputButton = new Button("Input words");
		menu.getChildren().addAll(practiceButton, inputButton);

		//adds the menu to the top of the main layout
		layout.setTop(menu);

		//sets the event handling for both navigation buttons
		practiceButton.setOnMouseClicked((event) -> {
			layout.setCenter(practiceView.getView());
		});

		inputButton.setOnMouseClicked((event) -> {
			layout.setCenter(inputView.getView());
		});

		//sets the default layout when the application launches
		layout.setCenter(practiceView.getView());

		//creates a scene, specifying the layout, height and width
		Scene view = new Scene(layout, 500, 500);

		window.setScene(view);
		window.show();
	}
}
