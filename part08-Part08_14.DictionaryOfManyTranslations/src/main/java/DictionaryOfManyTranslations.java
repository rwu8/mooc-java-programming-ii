import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
	private HashMap<String, ArrayList<String>> dictionary;

	public DictionaryOfManyTranslations() {
		this.dictionary = new HashMap<>();
	}

	public void add(String word, String translation) {
		this.dictionary.putIfAbsent(word, new ArrayList<>());
		this.dictionary.get(word).add(translation);
	}

	public ArrayList<String> translate(String word) {
		ArrayList item = this.dictionary.get(word);
		if (item == null) {
			ArrayList<String> empty = new ArrayList<>();
			return empty;
		} else {
			return this.dictionary.get(word);
		}
	}

	public void remove(String word) {
		this.dictionary.remove(word);
	}
}
