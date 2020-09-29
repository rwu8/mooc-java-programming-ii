package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {
	@Override
	public void start(Stage window) {
		Button buttonComponent = new Button("This is a button");
		TextField textComponent = new TextField("Text element");

		FlowPane componentGroup = new FlowPane();
		componentGroup.getChildren().add(buttonComponent);
		componentGroup.getChildren().add(textComponent);

		Scene view = new Scene(componentGroup);

		window.setScene(view);
		window.show();
	}

    public static void main(String[] args) {
		launch(ButtonAndTextFieldApplication.class);
    }


}
