package a6;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhraseCompleterTest {

	@Test
	public void testBinarySearchForKey() {
		String[] phrases = new String[] {"a boy", "the cat"};
		String key = "a";
		int index = PhraseCompleter.binarySearchForPartialKeyMatch(phrases, key);
		assertEquals("failed to find with partial key", 0, index);
		key = "the";
		index = PhraseCompleter.binarySearchForPartialKeyMatch(phrases, key);
		assertEquals("failed to find with partial key", 1, index);
		key = "who";
		index = PhraseCompleter.binarySearchForPartialKeyMatch(phrases, key);
		assertEquals("failed to find with partial key", -1, index);
		key = "a boy is";
		index = PhraseCompleter.binarySearchForPartialKeyMatch(phrases, key);
		assertEquals("failed to find with partial key", -1, index);
	}

	@Test
	public void testsubNCharacters() {
		String result = PhraseCompleter.subNCharacters("a cat", 2);
		assertEquals("failed to make subphrase", "a ", result);
		result = PhraseCompleter.subNCharacters("a cat", 10);
		assertEquals("failed to make subphrase when initial phrase is shorter", "a cat", result);
	}
	
	@Test
	public void testGetMatches() {
		String[] phrases = new String[] {"a boy", "the cat"};
		String[] suggestions = PhraseCompleter.getUpToNumKeyMatches(phrases, "a", 0, 2);
		assertEquals("failed to find a suggestion", "a boy", suggestions[0]);
		assertEquals("failed to finish with null", null, suggestions[1]);
	}

}
