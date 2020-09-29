package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi there, please give a title for the application: ");
		String title = scanner.nextLine();
		Application.launch(UserTitle.class, "--title=" + title); //passes the title parameter from the user input


	}

}
