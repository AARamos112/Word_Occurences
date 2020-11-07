//Author Name: Angel Ramos
//Date: 10/18/2020
//Program Name: Ramos_module7_word_occurrence
//Purpose: create a text analyzer to count word frequencies
package application;

/**
 * Purpose: create a text analyzer to count word frequencies
 * @author Angel Ramos
 *
 */
public class Ramos_text_analyzer implements Comparable<Ramos_text_analyzer>{
	private String word = "";
	private int wordCount = 0;
	
	/**
	 * Purpose: create a text analyzer to count word frequencies
	 * @author Angel Ramos
	 * @param word
	 * @param wordCount
	 */
	public Ramos_text_analyzer(String word, int wordCount) {
		setWord(word);
		setWordCount(wordCount);
	}
	/**
	 * method for getting the word
	 * @return returns a string
	 */
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	@Override
	public int compareTo(Ramos_text_analyzer o) {
		return  o.getWordCount() - this.getWordCount();
	}
	
	@Override
	public String toString() {
		return " [" + word + " = " + wordCount + "]" + "\n";
	}
		
}
