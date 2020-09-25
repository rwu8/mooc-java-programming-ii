import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
	public int compare(Card c1, Card c2) {
		if (c1.getSuit().ordinal() == c2.getSuit().ordinal()) {
//			if (c1.getValue() == 2 && c2.getValue() != 2) {
//				return 15 - c2.getValue();
//			} else if (c2.getValue() == 2 && c1.getValue() != 2) {
//				return c1.getValue() - 15;
//			}
			return c1.getValue() - c2.getValue();
		}

		return c1.getSuit().ordinal() - c2.getSuit().ordinal();
	}
}
