package edu.epam.regex.service.impl;

import edu.epam.regex.data.TextData;
import edu.epam.regex.service.TextService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TextServiceImplTest {

    TextService textService;

    @BeforeTest
    public void setUp() {
        this.textService = new TextServiceImpl();
    }

    @Test
    public void testCountDuplicateWords() {
        String text = TextData.TEXT;
        String nextLine = "\n";
        String result = textService.countDuplicateWords(text).trim();
        String expResult = TextData.DUPLICATE_WORDS.trim();

        assertEquals(result, expResult);
    }

    @Test
    public void testSortParagraphsBySentenceNumber() {
        String text = "It is a established fact that a reader will be of a page when looking at its layout...\n" +
                "    Bye бандерлоги.";
        List<String> result = textService.sortParagraphsBySentenceNumber(text);
        List<String> expResult = new ArrayList<>();
        expResult.add("    Bye бандерлоги.");
        expResult.add("It is a established fact that a reader will be of a page when looking at its layout...");

        assertEquals(result, expResult);
    }

    @Test
    public void testCountVowels() {
        String text = TextData.TEXT;
        int result = textService.countVowels(text);
        int expResult = 241;
        assertEquals(result, expResult);
    }

    @Test
    public void testCountConsonants() {
        String text = TextData.TEXT;
        int result = textService.countConsonants(text);
        int expResult = 554;
        assertEquals(result, expResult);
    }

    @Test
    public void testFindSentenceWithLongestWord() {
        String text = TextData.TEXT;
        String result = textService.findSentenceWithLongestWord(text);
        String expResult = TextData.LONGEST_WORD_IN_TEXT;
        assertEquals(result, expResult);
    }

    @Test
    public void testDeleteSentencesWithWordsLessThanGiven() {
        String text = TextData.TEXT;
        int amount = 5;
        String result = textService.deleteSentencesWithWordsLessThanGiven(text, amount);
        String expResult = TextData.SENTENCE_WITH_WORDS_LESS_THAN_GIVEN;
        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.textService = null;
    }
}