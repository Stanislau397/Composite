package edu.epam.regex.parser;

import edu.epam.regex.composite.CharacterType;
import edu.epam.regex.composite.ComponentType;
import edu.epam.regex.composite.impl.CharacterComposite;
import edu.epam.regex.composite.impl.TextComposite;

public class CharacterParser extends AbstractParser {

    private static final String CHARACTER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "[.]{3}|[.!,?]";

    @Override
    public TextComposite parse(String lexeme) {
        TextComposite characterComposite = new TextComposite(ComponentType.CHARACTER);
        String[] symbols = lexeme.split(CHARACTER_REGEX);
        for (String symbol : symbols) {

            if (symbol.matches(PUNCTUATION_REGEX)) {
                CharacterComposite punctuationComposite = new CharacterComposite(symbol, CharacterType.PUNCTUATION);
                characterComposite.add(punctuationComposite);
            } else {
                CharacterComposite symbolComposite = new CharacterComposite(symbol, CharacterType.SYMBOL);
                characterComposite.add(symbolComposite);
            }
        }
        return characterComposite;
    }
}
