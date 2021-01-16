package edu.epam.regex.parser;

import edu.epam.regex.composite.impl.TextComposite;
import edu.epam.regex.data.DataConstant;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeParserTest {

    LexemeParser lexemeParser;

    @BeforeTest
    public void setUp() {
        this.lexemeParser = new LexemeParser();
    }

    @Test
    public void testParse() {
        String text = DataConstant.TEXT;
        TextComposite lexemeComposite = lexemeParser.parse(text);
        int result = lexemeComposite.size();
        int expResult = 280;
        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.lexemeParser = null;
    }
}