
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		ArrayList<String> inputs = new ArrayList<>();

		while (true) {
			String input = scanner.nextLine();
			if ((input.isEmpty())) {
				break;
			}

			inputs.add(input);
		}

		inputs.stream().forEach(item -> System.out.println(item));
    }
}
