package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

	public static void main(String[] args) {
		launch(TextStatisticsApplication.class);
	}

	@Override
	public void start(Stage window) throws Exception {
		BorderPane layout = new BorderPane();
		HBox horizontalBox = new HBox();
		horizontalBox.setSpacing(10);
		Label letterLabel = new Label();
		Label wordLabel = new Label();
		Label longestWord = new Label();
		horizontalBox.getChildren().add(letterLabel);
		horizontalBox.getChildren().add(wordLabel);
		horizontalBox.getChildren().add(longestWord);

		TextArea textField = new TextArea("");

		textField.textProperty().addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
			int characterCount = newValue.length();
			String[] parts = newValue.split(" ");
			int words = parts.length;
			String longest = Arrays.stream(parts)
					.sorted((s1, s2) -> s2.length() - s1.length())
					.findFirst()
					.get();

			letterLabel.setText("Letters: " + characterCount);
			wordLabel.setText("Words: " + words);
			longestWord.setText("The longest word is: " + longest);
		});

		layout.setCenter(textField);
		layout.setBottom(horizontalBox);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();

	}

}
