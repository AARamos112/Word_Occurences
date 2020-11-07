//Author Name: Angel Ramos
//Date: 10/18/2020
//Program Name: Ramos_module7_word_occurrence
//Purpose: test method for word count
package application;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
/**
 * Junit testing class
 * @author Angel Ramos
 *
 */
public class testAnalyzer {

	@Test
	public void test() {
		Ramos_text_analyzer test = new Ramos_text_analyzer("word", 0);
		int output = test.getWordCount();
		assertEquals(0, output);
	}

}
