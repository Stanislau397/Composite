package edu.epam.regex.parser;

import edu.epam.regex.composite.impl.TextComposite;
import edu.epam.regex.data.TextData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceParserTest {

    SentenceParser sentenceParser;

    @BeforeTest
    public void setUp() {
        this.sentenceParser = new SentenceParser();
    }

    @Test
    public void testParse() {
        String text = TextData.TEXT;
        TextComposite sentenceComposite = sentenceParser.parse(text);
        int result = sentenceComposite.size();
        int expResult = 6;
        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.sentenceParser = null;
    }
}