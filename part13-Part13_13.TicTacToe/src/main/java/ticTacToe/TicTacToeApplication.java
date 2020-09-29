package ticTacToe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

	//sets the variables that are required to initialise the game
	String currentPlayer = "X";
	ArrayList<Button> buttons = new ArrayList<>();

	public static void main(String[] args) {
		launch(TicTacToeApplication.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Specify the elements that will be part of the UI
		BorderPane layout = new BorderPane();
		Label status = new Label("Turn: " + currentPlayer);
		status.setFont(Font.font("Monospaced", 25));

		GridPane gameBoard = new GridPane();
		gameBoard.setPadding(new Insets(10, 10, 10, 10));
		gameBoard.setHgap(10);
		gameBoard.setVgap(10);

		//creates 9 buttons with the same characteristics
		for (int i = 0; i < 9; i++) {
			Button button = new Button();
			button.setFont(Font.font("Monospaced", 25));
			button.setMinSize(70, 70);
			button.setMaxSize(70, 70);

			//main button logic
			button.setOnMouseClicked((event) -> {
				//checks if the game is still ongoing or if there's a draw
				if (status.getText().startsWith("Winner: ") || status.getText().equals("It's a draw!")) {
					button.disarm();  //if that's the case it disables the buttons
				} else if (button.getText().isEmpty()) {
					//otherwise it checks if the button is empty (not used by the other player)
					button.setText(currentPlayer); //and sets the current player variable to it
					if (checkIfWinner()) {
						//if there's a winner it sets the status label to represent the change
						status.setText("The end!");
					} else if(allBoxesAreFilled()) {
						//otherwise if all the boxes are filled it displays a message that it's a draw
						status.setText("It's a draw!");
					} else {
						//if the game is still ongoing, the turn changes to the next player and the status
						//label reflects the next player's turn
						takeTurn();
						status.setText("Turn: " + currentPlayer);
					}
				}
			});
			//adds the buttons to the button arrayList
			buttons.add(button);
		}

		//adds all 9 buttons to the game board
		gameBoard.add(buttons.get(0), 0, 0);
		gameBoard.add(buttons.get(1), 0, 1);
		gameBoard.add(buttons.get(2), 0, 2);
		gameBoard.add(buttons.get(3), 1, 0);
		gameBoard.add(buttons.get(4), 1, 1);
		gameBoard.add(buttons.get(5), 1, 2);
		gameBoard.add(buttons.get(6), 2, 0);
		gameBoard.add(buttons.get(7), 2, 1);
		gameBoard.add(buttons.get(8), 2, 2);

		//specified where the status and the gameboard will be placed in the scene
		layout.setTop(status);
		layout.setCenter(gameBoard);

		//starts the scene and shows it to the window
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.show();

	}

	//the takeTurn method changes the variable for currentPlayer between X or 0
	public void takeTurn() {
		if (currentPlayer.equals("X")) {
			currentPlayer = "O";
		} else if (currentPlayer.equals("O")) {
			currentPlayer = "X";
		}
	}

	//checks if any of the buttons are still available, to check if it's possible to keep playing
	public boolean allBoxesAreFilled() {
		for (Button b : buttons) {
			if (b.getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	//checks if there's a winner with the game rules below
	public boolean checkIfWinner() {
		return checkVerticalColumns() || checkHorizontalRows() || checkDiagonals();
	}

	//checks for winners on the vertical columns
	public boolean checkVerticalColumns() {
		//checks the first vertical column for a winner
		if (!buttons.get(0).getText().isEmpty() && ((buttons.get(0).getText().equals(buttons.get(1).getText()))
				&& (buttons.get(0).getText().equals(buttons.get(2).getText())))) {
			return true;
		}

		//checks the second vertical column
		if (!buttons.get(3).getText().isEmpty() && ((buttons.get(3).getText().equals(buttons.get(4).getText()))
				&& (buttons.get(3).getText().equals(buttons.get(5).getText())))) {
			return true;
		}
		//checks the third vertical column
		if (!buttons.get(6).getText().isEmpty() && ((buttons.get(6).getText().equals(buttons.get(7).getText()))
				&& (buttons.get(6).getText().equals(buttons.get(8).getText())))) {
			return true;
		}

		return false;
	}

	//checks for winners on the rows
	public boolean checkHorizontalRows() {
		//checks first horizontal row for a winner
		if (!buttons.get(0).getText().isEmpty() && ((buttons.get(0).getText().equals(buttons.get(3).getText()))
				&& (buttons.get(0).getText().equals(buttons.get(6).getText())))) {
			return true;
		}

		//checks second horizontal row for a winner
		if (!buttons.get(1).getText().isEmpty() && ((buttons.get(1).getText().equals(buttons.get(4).getText()))
				&& (buttons.get(1).getText().equals(buttons.get(7).getText())))) {
			return true;
		}
		//checks third horizontal row for a winner
		if (!buttons.get(2).getText().isEmpty() && ((buttons.get(2).getText().equals(buttons.get(5).getText()))
				&& (buttons.get(2).getText().equals(buttons.get(8).getText())))) {
			return true;
		}
		return false;
	}

	//checks for winners diagonally
	public boolean checkDiagonals() {
		//checks for first horizontal for a winner
		if (!buttons.get(0).getText().isEmpty() && ((buttons.get(0).getText().equals(buttons.get(4).getText()))
				&& (buttons.get(0).getText().equals(buttons.get(8).getText())))) {
			return true;
		}
		//checks for second horizontal for a winner
		if (!buttons.get(2).getText().isEmpty() && ((buttons.get(2).getText().equals(buttons.get(4).getText()))
				&& (buttons.get(2).getText().equals(buttons.get(6).getText())))) {
			return true;
		}
		return false;
	}

}
