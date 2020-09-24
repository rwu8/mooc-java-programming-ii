
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
		ArrayList<String> inputs = new ArrayList<>();
		ArrayList<String> negative = new ArrayList<>();

		while (true) {
			String input = scanner.nextLine();
			if (input.equals("end")) {
				break;
			}

			inputs.add(input);
		}

		double average = 0;

		System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
		String avg = scanner.nextLine();
		if (avg.equals("p")) {
			average = inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(x -> x > 0).average().getAsDouble();
			System.out.println("Average of the negative numbers: " + average);
		} else if (avg.equals("n")) {
			average = inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(x -> x < 0).average().getAsDouble();
			System.out.println("Average of the positive numbers: " + average);
		}
    }
}
