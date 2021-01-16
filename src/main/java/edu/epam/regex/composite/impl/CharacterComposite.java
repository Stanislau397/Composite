package edu.epam.regex.composite.impl;

import edu.epam.regex.composite.CharacterType;
import edu.epam.regex.composite.TextComponent;

public class CharacterComposite implements TextComponent {

    private CharacterType type;
    private String character;

    public CharacterComposite(String character, CharacterType type) {
        this.character = character;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    public CharacterType getType() {
        return type;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(character);
        return sb.toString();
    }
}
