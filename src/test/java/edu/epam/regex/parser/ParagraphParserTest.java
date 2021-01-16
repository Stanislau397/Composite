package edu.epam.regex.parser;

import edu.epam.regex.composite.impl.TextComposite;
import edu.epam.regex.data.DataConstant;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {

    ParagraphParser paragraphParser;

    @BeforeTest
    public void setUp() {
        this.paragraphParser = new ParagraphParser();
    }

    @Test
    public void testParse() {
        String text = DataConstant.TEXT;
        TextComposite paragraphComposite = paragraphParser.parse(text);
        int result = paragraphComposite.size();
        int expResult = 4;
        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.paragraphParser = null;
    }
}