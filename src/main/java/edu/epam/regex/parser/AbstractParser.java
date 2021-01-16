package edu.epam.regex.parser;

import edu.epam.regex.composite.impl.TextComposite;

public abstract class AbstractParser {

    public abstract TextComposite parse(String s);
}
