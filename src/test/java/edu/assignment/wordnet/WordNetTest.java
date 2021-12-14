
package edu.assignment.wordnet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author vahbuna
 */
class WordNetTest {

    @Test
    void testNullSynset() {
        assertThrows(IllegalArgumentException.class, () -> {new WordNet(null,
                "data/wordnet/hypernyms100-subgraph.txt");});
    }

    @Test
    void testNullHypernym() {
        assertThrows(IllegalArgumentException.class, () -> {new WordNet("data/wordnet/synsets100-subgraph.txt",
                null);});
    }

    @Test
    void testInvalidRoot() {
        assertThrows(IllegalArgumentException.class, () -> {new WordNet("data/wordnet/synsets3.txt",
                "data/wordnet/hypernyms3InvalidTwoRoots.txt");});
    }

    @Test
    void testInvalidCycle() {
        assertThrows(IllegalArgumentException.class, () -> {new WordNet("data/wordnet/synsets6.txt",
                "data/wordnet/hypernyms6InvalidCycle.txt");});
    }

    /**
     * read a synset and a hypernet file.
     */
    @Test
    void allOk() {
        WordNet wordnet = new WordNet("data/wordnet/synsets100-subgraph.txt",
                "data/wordnet/hypernyms100-subgraph.txt");
    }

    /**
     * if string is a valid noun.
     */
    @Test
    void isNounTest() {
        WordNet wordnet = new WordNet("data/wordnet/synsets100-subgraph.txt",
                "data/wordnet/hypernyms100-subgraph.txt");

        assertTrue(wordnet.isNoun("CRP"));
        assertFalse(wordnet.isNoun("CRP1"));
    }
}
