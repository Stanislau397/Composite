package edu.epam.regex.parser;

import edu.epam.regex.composite.CharacterType;
import edu.epam.regex.composite.ComponentType;
import edu.epam.regex.composite.TextComponent;
import edu.epam.regex.composite.impl.CharacterComposite;
import edu.epam.regex.composite.impl.TextComposite;

public class LexemeParser extends AbstractParser{

    private static final String LEXEME_REGEX = "[\\n]|[\\t]|[ ]";
    private static final AbstractParser nextParser = new CharacterParser();

    @Override
    public TextComposite parse(String sentence) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] lexemes = sentence.split(LEXEME_REGEX);
        String space = " ";
        for (String lexeme : lexemes) {
            if (!(lexeme.isEmpty())) {
                TextComponent characterComponent = nextParser.parse(lexeme);
                lexemeComposite.add(characterComponent);
                CharacterComposite symbol = new CharacterComposite(space, CharacterType.SYMBOL);
                lexemeComposite.add(symbol);
            }
        }
        return lexemeComposite;
    }
}
