package edu.epam.regex.parser;

import edu.epam.regex.composite.ComponentType;
import edu.epam.regex.composite.TextComponent;
import edu.epam.regex.composite.impl.TextComposite;

public class SentenceParser extends AbstractParser {

    private final String SENTENCE_REGEX = "(?<=[.!?])\\s";
    private static final AbstractParser nextParser = new LexemeParser();

    @Override
    public TextComposite parse(String paragraph) {
        TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
        String[] sentences = paragraph.split(SENTENCE_REGEX);
        for (String sentence : sentences) {
            if (!(sentence.isEmpty())) {
                TextComponent lexemeComponent = nextParser.parse(sentence);
                sentenceComposite.add(lexemeComponent);
            }
        }
        return sentenceComposite;
    }
}
