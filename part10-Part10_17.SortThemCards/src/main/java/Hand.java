import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Hand implements Comparable<Hand> {
	private ArrayList<Card> hand;

	public Hand() {
		this.hand = new ArrayList<>();
	}

	public void add(Card card) {
		this.hand.add(card);
	}

	public void print() {
		Iterator<Card> iterator = hand.iterator();

		while(iterator.hasNext()) {
			Card nextCard = iterator.next();
			System.out.println(nextCard);
		}
	}

	public void sort() {
		Comparator<Card> comparator = Comparator
				.comparing(Card::getValue)
				.thenComparing(Card::getSuit);

		Collections.sort(hand, comparator);
	}

	@Override
	public int compareTo(Hand handToCompare) {
//		int thisHandValue = hand.stream().reduce(0, (prev, curr) -> prev.getValue() + curr.getValue());
		int thisHandValue = 0;
		for (Card card : hand) {
			thisHandValue += card.getValue();
		}
		int compareHandValue = 0;
		for (Card card : handToCompare.hand) {
			compareHandValue += card.getValue();
		}
//		if (thisHandValue == compareHandValue) {
//
//		}
		return thisHandValue - compareHandValue;
	}

	public void sortBySuit() {
		Collections.sort(hand, new BySuitInValueOrder());
	}
}
