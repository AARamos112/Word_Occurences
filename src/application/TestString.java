//Author Name: Angel Ramos
//Date: 10/18/2020
//Program Name: Ramos_module7_word_occurrence
//Purpose: test method for word
package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestString {

	@Test
	public void test() {
		Ramos_text_analyzer test = new Ramos_text_analyzer("word", 0);
		String output = test.getWord();
		assertEquals("word", output);
	}

}
