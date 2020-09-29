package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
	private ArrayList<String> words;
	private HashMap<String, String> translations;

	public Dictionary(){
		this.words = new ArrayList();
		this.translations = new HashMap();

		//adds sample word
		addWord("palabra", "word");
	}

	public String getTranslation(String word){
		if(this.translations.containsKey(word)){
			return this.translations.get(word);
		}

		return "Translation not found";
	}

	public void addWord(String word, String translation){
		if(!this.translations.containsKey(word)){
			this.words.add(word);
		}

		this.translations.put(word, translation);
	}

	public String getRandomWord(){
		Random rand = new Random();
		return this.words.get(rand.nextInt(this.words.size()));
	}

}
