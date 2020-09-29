package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
	private Dictionary dictionary;

	public InputView(Dictionary dictionary){
		this.dictionary = dictionary;
	}

	public Parent getView(){
		//Specifies the elements of the view
		Label addWordText = new Label("Word:");
		TextField addWordField = new TextField();
		Label addTranslationText = new Label("Translation:");
		TextField addTranslationField = new TextField();
		Button addButton = new Button("Add");

		//add the elemtns to the layout
		GridPane layout = new GridPane();
		layout.add(addWordText, 0, 0);
		layout.add(addWordField, 0, 1);
		layout.add(addTranslationText, 0, 2);
		layout.add(addTranslationField, 0, 3);
		layout.add(addButton, 0, 4);

		//styling the layout
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));

		//specifies the action of the button (using the dictioanry methods)
		addButton.setOnMouseClicked((event) -> {
			this.dictionary.addWord(addWordField.getText(), addTranslationField.getText());
			addWordField.clear();
			addTranslationField.clear();
		});

		return layout;

	}

}
