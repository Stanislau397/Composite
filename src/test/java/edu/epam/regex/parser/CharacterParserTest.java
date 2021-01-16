package edu.epam.regex.parser;

import edu.epam.regex.composite.impl.TextComposite;
import edu.epam.regex.data.TextData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharacterParserTest {

    CharacterParser characterParser;

    @BeforeTest
    public void setUp() {
        this.characterParser = new CharacterParser();
    }

    @Test
    public void testParse() {
        String text = TextData.TEXT;
        TextComposite characterComposite = characterParser.parse(text);
        int result = characterComposite.size();
        int expResult = 795;
        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.characterParser = null;
    }
}