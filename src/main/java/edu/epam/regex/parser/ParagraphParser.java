package edu.epam.regex.parser;

import edu.epam.regex.composite.ComponentType;
import edu.epam.regex.composite.TextComponent;
import edu.epam.regex.composite.impl.TextComposite;

public class ParagraphParser extends AbstractParser {

    private static final String PARAGRAPH_REGEX = "(?m)(?=^\\s{4})";
    private static final AbstractParser nextParser = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
        TextComponent sentenceComponent;
        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        for (String paragraph : paragraphs) {
            if (!(paragraph.isEmpty())) {
                sentenceComponent = nextParser.parse(paragraph);
                paragraphComposite.add(sentenceComponent);
            }
        }
        return paragraphComposite;
    }
}
