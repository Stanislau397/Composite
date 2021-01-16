package edu.epam.regex.composite;

public interface TextComponent {

    void add(TextComponent component);

    void remove(TextComponent component);

    int size();
}
