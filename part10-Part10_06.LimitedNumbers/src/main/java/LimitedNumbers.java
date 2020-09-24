
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		ArrayList<String> inputs = new ArrayList<>();

		while (true) {
			String input = scanner.nextLine();
			if (Integer.valueOf(input) < 0) {
				break;
			}

			inputs.add(input);
		}

		inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(s -> s > 0 && s < 6).forEach(s -> System.out.println(s));
    }
}
