
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		ArrayList<Book> inputs = new ArrayList<>();

		while (true) {
			System.out.println("Input the name of the book, empty stops: ");
			String name = scanner.nextLine();
			if (name.isEmpty()) {
				break;
			}

			System.out.println("Input the age recommendation: ");
			Integer age = Integer.valueOf(scanner.nextLine());

			inputs.add(new Book(name, age));
		}

		System.out.println(inputs.size() + " books in total.");

		Comparator<Book> comparator = Comparator
				.comparing(Book::getAge)
				.thenComparing(Book::getName);
		Collections.sort(inputs, comparator);

		System.out.println("Books");
		for (Book book: inputs) {
			System.out.println(book);
		}
    }

}
